package com.dio.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable() // disabilita ataque por csrf
        .authorizeHttpRequests().anyRequest().authenticated() // quem faz a requisicao tem q ta autenticado
        .and()
        .httpBasic();

        return http.build();
    }

    // protected void configure(HttpSecurity http) throws Exception{
    //     http.csrf().disable() // disabilita ataque por csrf
    //     .authorizeHttpRequests().anyRequest().authenticated() // quem faz a requisicao tem q ta autenticado
    //     .and()
    //     .httpBasic();
    // }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
        .withUser("usuario")
        .password("{noop}senha") // noop pra nao criptografar senha, sem o noop precisa de laguem pra criptografar
        .roles("USER");
    }
}
