package com.sda.onlineBets.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> {

            auth.requestMatchers("/registration").permitAll();
            auth.requestMatchers("/cssStyle/*").permitAll();

            auth.requestMatchers("/addEvent").permitAll();


            auth.requestMatchers("/home").authenticated();

        }).httpBasic();

        httpSecurity
                .formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable().authorizeHttpRequests()
                .and()
                .cors().disable().authorizeHttpRequests();


        return httpSecurity.build();

    }


}
