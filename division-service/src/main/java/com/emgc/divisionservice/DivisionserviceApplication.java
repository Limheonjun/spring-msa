package com.emgc.divisionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class DivisionserviceApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(DivisionserviceApplication.class, args);
	}

}
