package com.emgc.divisionservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DivisionRouter {

	private final DivisionHandler orderHandler;

	@Bean
	public RouterFunction<ServerResponse> orderRouter() {
		return RouterFunctions.route()
			.path("division", this::subOrderRouter)
			.build();
	}

	private RouterFunction<ServerResponse> subOrderRouter() {
		return RouterFunctions.route()
			.GET("{division-operand}", orderHandler::doDivision)
			.build();
	}

}
