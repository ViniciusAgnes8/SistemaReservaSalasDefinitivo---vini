package com.example.SistemaReservaSalas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.SistemaReservaSalas")
@EnableJpaRepositories(basePackages = "com.example.SistemaReservaSalas.repositories")
@EntityScan(basePackages = "com.example.SistemaReservaSalas.models")
public class SistemaReservaSalasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaReservaSalasApplication.class, args);
	}

}
