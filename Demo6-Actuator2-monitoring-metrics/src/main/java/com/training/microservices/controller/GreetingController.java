package com.training.microservices.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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

	private TPSHealth health;
	private CounterService counterService;
	private GaugeService gaugeService;

	@Autowired
	GreetingController(TPSHealth health, CounterService counterService, GaugeService gaugeService) {
		this.health = health;
		this.counterService = counterService;
		this.gaugeService = gaugeService;
	}

	@CrossOrigin
	@RequestMapping("/")
	Greet greet() {
		logger.info("Serving Request....!!!");
		health.updateTx();
		this.counterService.increment("greet.txnCount");
		gaugeService.submit("greet.customgauge", 1.0);
		return new Greet("Hello World!");
	}

}
