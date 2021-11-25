package com.emgc.divisionservice.router;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.emgc.divisionservice.dto.DivisionResponseDto;
import com.emgc.divisionservice.service.DivisionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DivisionHandler {

	private final DivisionService service;

	public Mono<ServerResponse> doDivision(ServerRequest serverRequest) {
		int input = Integer.parseInt(serverRequest.pathVariable("division-operand"));
		Mono<DivisionResponseDto> dto = service.doDivision(input);
		return ServerResponse.ok().body(dto, DivisionResponseDto.class);
	}

}
