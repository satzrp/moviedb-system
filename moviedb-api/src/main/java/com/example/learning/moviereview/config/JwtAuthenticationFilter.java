package com.example.learning.moviereview.config;

import com.example.learning.moviereview.utils.jwt.JwtManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTH_TOKEN_PREFIX = "Bearer ";
    private final JwtManager jwtManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationFilter(JwtManager jwtManager, UserDetailsService userDetailsService) {
        this.jwtManager = jwtManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final var authHeader = getAuthorizationHeader(request);
        if (isInvalidAuthorizationHeader(authHeader)) {
            filterChain.doFilter(request, response);
            return;
        }
        final var jwtToken = getJwtTokenFromAuthHeader(authHeader);
        final var userEmail = jwtManager.extractUsernameFromToken(jwtToken);
        if(isNotAuthenticated(userEmail)) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
            if(jwtManager.isTokenValid(jwtToken, userDetails)) {
                updateAuthTokenInContext(request, userDetails);
            }
        }
        filterChain.doFilter(request, response);
    }

    private void updateAuthTokenInContext(HttpServletRequest request, UserDetails userDetails) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    private boolean isNotAuthenticated(String userEmail) {
        return userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null;
    }

    private String getJwtTokenFromAuthHeader(String authHeader) {
        return authHeader.substring(AUTH_TOKEN_PREFIX.length());
    }

    private boolean isInvalidAuthorizationHeader(String authHeader) {
        return authHeader == null ||!authHeader.startsWith(AUTH_TOKEN_PREFIX);
    }

    private String getAuthorizationHeader(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }
}
