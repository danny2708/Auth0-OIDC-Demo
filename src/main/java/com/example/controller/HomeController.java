package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class HomeController {

    @Value("${auth0.client-id:YOUR_CLIENT_ID}")
    private String clientId;

    @Value("${auth0.domain:https://YOUR_AUTH0_DOMAIN/}")
    private String auth0Domain;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser == null) {
            return "redirect:/";
        }
        model.addAttribute("user", oidcUser);
        return "profile";
    }

    @GetMapping("/logout-auth0")
    public void logoutAuth0(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        String returnTo = URLEncoder.encode("http://localhost:8080/", StandardCharsets.UTF_8);
        String logoutUrl = auth0Domain.replaceAll("/+$", "")
                + "/v2/logout?client_id=" + clientId + "&returnTo=" + returnTo;
        response.sendRedirect(logoutUrl);
    }
}
