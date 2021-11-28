package com.emgc.integrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class IntegrationServiceApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(IntegrationServiceApplication.class, args);
	}

}
