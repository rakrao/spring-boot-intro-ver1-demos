package com.training.microservices.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.training.microservices.mail.Mailer;

@Component
public class Receiver {
	@Autowired
	private Mailer mailer;

	@Bean
	public Queue queue() {
		return new Queue("CustomerQ", false);
	}

	@RabbitListener(queues = "CustomerQ")
	public void processMessage(String email) {
		System.out.println(email);
		mailer.sendMail(email);
	}

}
