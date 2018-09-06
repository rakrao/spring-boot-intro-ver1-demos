package com.training.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Demo7DocumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo7DocumentationApplication.class, args);
	}
}
