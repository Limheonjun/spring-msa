package com.emgc.integrationservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.emgc.integrationservice.dto.MultiplyResponseDto;

import reactor.core.publisher.Mono;

@Service
public class MultiplyService {

	private final WebClient webClient;

	public MultiplyService() {
		webClient = WebClient.builder().build();
	}

	public Mono<MultiplyResponseDto> doMultiply(int temp) {
		return webClient.get()
			.uri("http://localhost:8092/multiply/" + temp)
			.exchangeToMono(this::exchange)
			.doOnNext(System.out::println)
			.doOnError(err -> System.out.println(err.getMessage()))
			;
	}

	private Mono<MultiplyResponseDto> exchange(ClientResponse cr) {
		int i = cr.rawStatusCode();
		System.out.println("Multiply Service Response Status Code : " + i);
		return cr.bodyToMono(MultiplyResponseDto.class);
	}

}
