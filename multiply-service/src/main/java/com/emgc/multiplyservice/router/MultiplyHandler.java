package com.emgc.multiplyservice.router;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.emgc.multiplyservice.dto.MultiplyResponseDto;
import com.emgc.multiplyservice.service.MultiplyService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MultiplyHandler {

	private final MultiplyService service;

	public Mono<ServerResponse> doMultiply(ServerRequest serverRequest) {
		int input = Integer.parseInt(serverRequest.pathVariable("multiply-operand"));
		Mono<MultiplyResponseDto> dto = service.doMultiply(input);
		return ServerResponse.ok().body(dto, MultiplyResponseDto.class);
	}

}
