package com.springsec.springsecsection2.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
		@Order(SecurityProperties.BASIC_AUTH_ORDER)
		SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests((requests) -> requests
        .requestMatchers("/myAccount", "/myBalance", "myCards", "/myLoans").authenticated()
        .requestMatchers("/contact", "notices").permitAll())
      .formLogin(withDefaults())
      .httpBasic(withDefaults());
			return http.build();
		}
}
