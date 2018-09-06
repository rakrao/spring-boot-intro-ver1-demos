package com.training.microservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class GreetController {
	
	@RequestMapping("/")
	String greet(){
		return "Hello World!!";
	}	
}
