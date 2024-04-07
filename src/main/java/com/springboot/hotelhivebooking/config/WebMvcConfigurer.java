package com.springboot.hotelhivebooking.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebMvcConfigurer<SecurityFilterChain> {
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

	// @Bean
	// @Order(0)
	// public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
	// 	http
	// 		.securityMatcher("/api/**")
	// 		.cors((cors) -> cors
	// 			.configurationSource(apiConfigurationSource())
	// 		)
	// 		...
	// 	return http.build();
	// }

	// @Bean
	// @Order(1)
	// public SecurityFilterChain myOtherFilterChain(HttpSecurity http) throws Exception {
	// 	http
    //         .securityMatcher("/api/**")
	// 		.cors((cors) -> cors
	// 			.configurationSource(myWebsiteConfigurationSource())
	// 		)
	// 		...
	// 	return http.build();
	// }

	// CorsConfigurationSource apiConfigurationSource() {
	// 	CorsConfiguration configuration = new CorsConfiguration();
	// 	configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
	// 	configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	// 	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	// 	source.registerCorsConfiguration("/**", configuration);
	// 	return source;
	// }
    // CorsConfigurationSource myWebsiteConfigurationSource() {
	// 	CorsConfiguration configuration = new CorsConfiguration();
	// 	configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
	// 	configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	// 	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	// 	source.registerCorsConfiguration("/**", configuration);
	// 	return source;
	// }

}




