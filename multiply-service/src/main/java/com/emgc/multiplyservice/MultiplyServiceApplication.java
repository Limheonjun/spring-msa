package com.emgc.multiplyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class MultiplyServiceApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(MultiplyServiceApplication.class, args);
	}

}
