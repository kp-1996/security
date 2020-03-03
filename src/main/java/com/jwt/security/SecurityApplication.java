package com.jwt.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaRepositories("com.jwt.security.repository")
@EntityScan("com.jwt.security.model")
@SpringBootApplication
public class SecurityApplication {

	private static final Logger logger = LoggerFactory.getLogger(SecurityApplication.class);
	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	      return new BCryptPasswordEncoder();
	 }
	 
	 	 
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
		logger.info("-----application started------");
	}

}
