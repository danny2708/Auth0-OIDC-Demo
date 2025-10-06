# Auth0 OIDC Demo (Spring Boot)
This is a minimal Spring Boot (Maven) project demonstrating SSO with Auth0 using OIDC.

## How to use
1. Fill in `src/main/resources/application.yml` with your Auth0 details:
   - `client-id`
   - `client-secret`
   - `issuer-uri` (like https://dev-xxxxx.us.auth0.com/)

2. Ensure in Auth0 application settings:
   - Allowed Callback URLs: `http://localhost:8080/login/oauth2/code/auth0`
   - Allowed Logout URLs: `http://localhost:8080/`

3. Build & run:
   ```
   mvn spring-boot:run
   ```
   or build jar:
   ```
   mvn package
   java -jar target/auth0-oidc-demo-0.0.1-SNAPSHOT.jar
   ```

## Notes
- Places that need your configuration are clearly marked with `// TODO` comments in files and placeholders in application.yml.
"# Auth0-OIDC-Demo" 
