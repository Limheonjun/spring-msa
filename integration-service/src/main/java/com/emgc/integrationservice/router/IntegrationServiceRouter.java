package com.emgc.integrationservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class IntegrationServiceRouter {

	private final IntegrationHandler handler;

	@Bean
	public RouterFunction<ServerResponse> integrationRouter() {
		return RouterFunctions.route()
			.path("operate", this::subIntegrationRouter)
			.build();
	}

	private RouterFunction<ServerResponse> subIntegrationRouter() {
		return RouterFunctions.route()
			.GET("{operand}", handler::doOperate)
			.build();
	}

}
