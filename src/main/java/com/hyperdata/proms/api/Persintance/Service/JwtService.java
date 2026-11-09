package com.hyperdata.proms.api.Persintance.Service;

import com.hyperdata.proms.api.Persintance.Entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;
    private final long expirationHours;
    private final String issuer;

    public JwtService(JwtEncoder jwtEncoder,
                      @Value("${app.jwt.expiration-hours:8}") long expirationHours,
                      @Value("${app.jwt.issuer:proms-api}") String issuer) {
        this.jwtEncoder = jwtEncoder;
        this.expirationHours = expirationHours;
        this.issuer = issuer;
    }

    public long getExpiresInSeconds() {
        return Duration.ofHours(expirationHours).toSeconds();
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        JwtClaimsSet.Builder claims = JwtClaimsSet.builder()
                .issuer(issuer)
                .subject(user.getId().toString())
                .issuedAt(now)
                .expiresAt(now.plus(Duration.ofHours(expirationHours)))
                .claim("email", user.getEmail())
                .claim("name", user.getFullName());
        if (user.getPlatformRole() != null) {
            claims.claim("platform_role", user.getPlatformRole());
        }
        JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();
        return jwtEncoder.encode(JwtEncoderParameters.from(header, claims.build())).getTokenValue();
    }
}