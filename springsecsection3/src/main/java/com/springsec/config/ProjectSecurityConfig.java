package com.springsec.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

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



    // @SuppressWarnings("deprecation")
    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //   UserDetails admin = User.withDefaultPasswordEncoder()
    //     .username("admin")
    //     .password("12345")
    //     .authorities("admin")
    //     .build();

    //   UserDetails user = User.withDefaultPasswordEncoder()
    //   .username("user")
    //   .password("12345")
    //   .authorities("read")
    //   .build();

    //   return new InMemoryUserDetailsManager(admin, user);
    // }

    // @Bean
    // public UserDetailsService userDetailsService(DataSource dataSource) {
    //   return new JdbcUserDetailsManager(dataSource);
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return NoOpPasswordEncoder.getInstance();
    }
}
