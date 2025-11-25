@Bean
public CorsFilter corsFilter() {
    CorsConfiguration config = new CorsConfiguration();
    
    // Accept anything (required for Kubernetes + Nginx)
    config.addAllowedOriginPattern("*");
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
    config.setAllowedHeaders(List.of("*"));
    config.setAllowCredentials(false); // Keep simple
    
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
}
