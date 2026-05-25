package com.example.Ejercicio12_Sistema_Monitoreo.feature.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.repository.ClientApplicationRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    private final ClientApplicationRepository repository;

    public ApiKeyFilter(ClientApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)

            throws ServletException, IOException {

        String path = request.getRequestURI();

        if (path.equals("/logs")
            && request.getMethod().equals("POST")) {

            String apiKey = request.getHeader("X-API-KEY");

            if (apiKey == null || apiKey.isBlank()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("API KEY requerida");
                return;
            }

            boolean exists = repository.existsByApiKey(apiKey);

            if (!exists) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("API KEY invalida");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}