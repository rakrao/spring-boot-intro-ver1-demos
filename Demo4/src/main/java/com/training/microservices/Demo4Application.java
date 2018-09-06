package com.training.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.microservices.messaging.Sender;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {

	@Autowired
	Sender sender;
	
    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
    	sender.send("Hello Messaging..!!!");
    }
}
