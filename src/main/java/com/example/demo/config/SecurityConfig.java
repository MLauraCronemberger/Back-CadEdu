package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//Configuração Básica para utilizar o JWT

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	//A partir daqui que configuramos tudo de segurança do nosso projeto
	@Bean
	private SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
		
		//Configuração que é melhor mantermos localmente, pq é uma vulnerabilidade que facilita nossos testes
		
		http.csrf(csrf -> csrf.disable());
		
		//Para usarmos o JWT dentro do nosso projeto
		
		http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
		
		//Como estamos utilizando o JWT e ele n precisa guardar nada em exceção:
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		
		return http.build();
		
	}
	

}
