package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpClient;
import java.security.Security;

@Configuration
public class DemoSecurityConfig {
    // no longer hard code users, gets user data from database
    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource datasource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(datasource);
        manager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        manager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("MANAGER")
        );
        // use HTTP Basic Authentication --> since we are overriding the security filter chain, we need to specify what http authentication method we are using.
        http.httpBasic(Customizer.withDefaults());

        // disable cross site request forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    };
}
