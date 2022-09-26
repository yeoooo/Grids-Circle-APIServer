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
                .antMatchers("/css/**", "/js/**", "/assets/**", "/index", "/").permitAll()
                .antMatchers("/management/**").authenticated()
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
//                .usernameParameter("asd")
//                .passwordParameter("asd")
                .and()
                .csrf()
                .disable();


        return http.build();

        }

}
