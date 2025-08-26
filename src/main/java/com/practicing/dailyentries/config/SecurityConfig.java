package com.practicing.dailyentries.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
			
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()); //csrf(Ataque csrf) --> DESABILITADO PROTEÇÃO/SEGURAÇÃO DE GRAVAÇÃO DE DADOS NA SEÇÃO, API REST NÃO GRAVA DADO EM SEÇÃO
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); //[.permitAll()] --> ESSE É UM CONTROLE GLOBAL E ESTÁ TUDO LIBERADO PORQUE O CONTROLE/SEGURANÇA SERÁ POR ROTA. CONFIGURAÇÃO DA PERMISSÃO PARA OS ENDPOINS/REQUISIÇÃO. PEMITE ALL. [.permitAll()] PODE SER ALTERADO PARA PERTIRI ACESSAR SOMENTE QUE UM PERFIL ESPECIFICO, ALEM DE OUTRAS OPÇÕES DE CONTROLE DE ACESSO APENAS MUDANDO ESSE METODO
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Profile("test")
	@Order(1)
	SecurityFilterChain h2SecurityFilterChain(HttpSecurity http) throws Exception {

		http.securityMatcher(PathRequest.toH2Console()).csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
		return http.build();
	}
}
