package com.training.microservices.bean;

import org.springframework.hateoas.ResourceSupport;

public class Greet extends ResourceSupport {
	private String message;

	public Greet() {
		// TODO Auto-generated constructor stub
	}

	public Greet(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Greet [message=" + message + "]";
	}

}
