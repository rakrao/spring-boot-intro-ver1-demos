package com.training.microservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservices.bean.Greet;
import com.training.microservices.bean.TPSHealth;

/*
@Controller
@ResponseBody
*/
@RestController
public class GreetingController {

	private static final Logger logger = Logger.getRootLogger();

	@Autowired
	private TPSHealth health;
	
	@RequestMapping("/greet")
	Greet greet() {
		logger.info("Serving Request....!!!");
		health.updateTx();
		return new Greet("Hello World!");
	}

	@RequestMapping("/greeting")
	@ResponseBody
	public HttpEntity<Greet> greeting(
			@RequestParam(value = "name", required = false, defaultValue = "HATEOAS") String name) {
		Greet greet = new Greet("Hello " + name);
		greet.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		return new ResponseEntity<Greet>(greet, HttpStatus.OK);
	}

}
