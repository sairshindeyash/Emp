package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.*")
@ComponentScan("com.example.*")
@EnableJpaRepositories(basePackages={"com.example"})
public class EmployeeCrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudOperationsApplication.class, args);
	}

}
