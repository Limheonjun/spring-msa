package com.emgc.multiplyservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MultiplyServiceRouter {

	private final MultiplyHandler multiplyHandler;

	@Bean
	public RouterFunction<ServerResponse> multiplyRouter() {
		return RouterFunctions.route()
			.path("multiply", this::subMultiplyRouter)
			.build();
	}

	private RouterFunction<ServerResponse> subMultiplyRouter() {
		return RouterFunctions.route()
			.GET("{multiply-operand}", multiplyHandler::doMultiply)
			.build();
	}

}
