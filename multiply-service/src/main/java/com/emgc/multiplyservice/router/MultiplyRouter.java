package com.emgc.multiplyservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MultiplyRouter {

	private final MultiplyHandler orderHandler;

	@Bean
	public RouterFunction<ServerResponse> orderRouter() {
		return RouterFunctions.route()
			.path("order", this::subOrderRouter)
			.build();
	}

	private RouterFunction<ServerResponse> subOrderRouter() {
		return RouterFunctions.route()
			.GET("{multiply-operand}", orderHandler::doMultiply)
			.build();
	}

}
