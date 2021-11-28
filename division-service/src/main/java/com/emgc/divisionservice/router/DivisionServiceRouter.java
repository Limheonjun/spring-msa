package com.emgc.divisionservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DivisionServiceRouter {

	private final DivisionHandler divisionHandler;

	@Bean
	public RouterFunction<ServerResponse> divisionRouter() {
		return RouterFunctions.route()
			.path("division", this::subDivisionRouter)
			.build();
	}

	private RouterFunction<ServerResponse> subDivisionRouter() {
		return RouterFunctions.route()
			.GET("{division-operand}", divisionHandler::doDivision)
			.build();
	}

}
