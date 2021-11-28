package com.emgc.integrationservice.router;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.emgc.integrationservice.dto.IntegrationRequestDto;
import com.emgc.integrationservice.dto.IntegrationResponseDto;
import com.emgc.integrationservice.service.IntegrationService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class IntegrationHandler {

	private final IntegrationService service;

	public Mono<ServerResponse> doOperate(ServerRequest serverRequest) {
		int input = Integer.parseInt(serverRequest.pathVariable("operand"));
		Mono<IntegrationResponseDto> dto = service.doOperate(input);
		return ServerResponse.ok().body(dto, IntegrationResponseDto.class);
	}
}
