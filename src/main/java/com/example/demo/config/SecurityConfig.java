package com.example.demo.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;

//Configuração Básica para utilizar o JWT

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Value("${jwt.public.key}")
	private RSAPublicKey publickey;
	
	@Value("${jwt.private.key}")
	private RSAPrivateKey privatekey;
	
	
	
	//A partir daqui que configuramos tudo de segurança do nosso projeto
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
		
		//Configuração que é melhor mantermos localmente, pq é uma vulnerabilidade que facilita nossos testes
		
		http.csrf(csrf -> csrf.disable());
		
		//Para usarmos o JWT dentro do nosso projeto
		
		http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
		
		//Como estamos utilizando o JWT e ele n precisa guardar nada em exceção:
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		
		return http.build();
		
	}
	
	//Criando um Decoder a partir da nossa chave pública, é o cara que vai fazer a descriptografia do JWT na requisição
	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(publickey).build();
		
	}
	
	@Bean
	public JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(this.publickey).privateKey(privatekey).build();
		var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);
		
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	


}
