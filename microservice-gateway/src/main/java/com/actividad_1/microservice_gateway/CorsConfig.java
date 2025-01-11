package com.actividad_1.microservice_gateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000");  // Origen permitido
        config.addAllowedMethod("GET");                    // Métodos permitidos
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedHeader("Authorization");         // Encabezados permitidos
        config.addAllowedHeader("Cache-Control");
        config.addAllowedHeader("Content-Type");
        config.setAllowCredentials(true);                  // Permitir credenciales
        
        // Aplicamos la configuración a todas las rutas (/**)
        source.registerCorsConfiguration("/**", config);
        
        return source;
    }
}
