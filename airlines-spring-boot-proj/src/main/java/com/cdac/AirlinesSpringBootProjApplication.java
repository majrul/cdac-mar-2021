package com.cdac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service", "dao"})
@EntityScan(basePackages = "model")
public class AirlinesSpringBootProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinesSpringBootProjApplication.class, args);
	}
	
}