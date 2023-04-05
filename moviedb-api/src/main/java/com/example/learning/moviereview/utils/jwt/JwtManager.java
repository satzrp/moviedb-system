package com.example.learning.moviereview.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtManager {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration.limit}")
    private long oneDayInMillis;

    public String generateJwtToken(UserDetails userDetails) {
        final var currentTime = new Date(System.currentTimeMillis());
        final var expirationTime = new Date(System.currentTimeMillis() + oneDayInMillis);
        return Jwts
                .builder()
                .setClaims(Collections.emptyMap())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(currentTime)
                .setExpiration(expirationTime)
                .signWith(getTokenSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String jwtToken, UserDetails userDetails) {
        final var userName = extractUsernameFromToken(jwtToken);
        return userDetails.getUsername().equals(userName) && !isTokenExpired(jwtToken);
    }

    public String extractUsernameFromToken(String jwtToken) {
        return extractClaimItem(jwtToken, Claims::getSubject);
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractClaimItem(jwtToken, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaimItem(String jwtToken, Function<Claims, T> claimItemResolver) {
        final var claims = extractClaimsFromToken(jwtToken);
        return claimItemResolver.apply(claims);
    }

    private Claims extractClaimsFromToken(String jwtToken) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getTokenSigningKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getTokenSigningKey() {
        final var keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
