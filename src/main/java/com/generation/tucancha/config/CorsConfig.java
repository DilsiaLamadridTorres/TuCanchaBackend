package com.generation.tucancha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Placeholder temporal para configuración CORS.
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Permite solicitudes desde cualquier origen.
        // En producción esto se restringe al dominio del frontend.
        config.addAllowedOrigin("https://dilsialamadridtorres.github.io");

        // Permite los métodos HTTP que usa el frontend.
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");

        // Permite todos los headers, incluyendo Authorization: Bearer <token>
        config.addAllowedHeader("*");

        // Permite que el navegador lea el header Authorization en las respuestas.
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Aplica esta configuración a todas las rutas.
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
