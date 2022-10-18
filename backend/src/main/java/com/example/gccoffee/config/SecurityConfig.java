package com.example.gccoffee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws
        Exception{
        http
                .authorizeRequests()

                .antMatchers("/css/**", "./static/**", "/assets/**", "/index", "/","/products").permitAll()
                .antMatchers("/management/**").authenticated()
//                .antMatchers("/management/**").permitAll()
                .antMatchers("/api/**").permitAll()

//                .anyRequest()
//                .authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .csrf()
                .disable();


        return http.build();

        }

}
