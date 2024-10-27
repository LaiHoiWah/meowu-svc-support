package com.meowu.svc.support.security.config.mvc;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig{

    @Bean
    public CorsFilter corsFilter(){
        // origins
        List<String> all = Lists.newArrayList(CorsConfiguration.ALL);

        // cors config
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods(Lists.newArrayList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(all);
        config.setAllowedOrigins(all);
        config.setAllowedOriginPatterns(all);
        config.setExposedHeaders(all);

        // set url mapping
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}
