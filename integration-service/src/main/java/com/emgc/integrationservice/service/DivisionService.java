package com.emgc.integrationservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.emgc.integrationservice.dto.DivisionResponseDto;

import reactor.core.publisher.Mono;

@Service
public class DivisionService {

	private final WebClient webClient;

	public DivisionService() {
		webClient = WebClient.builder().build();
	}

	public Mono<DivisionResponseDto> doDivision(int temp){
		return webClient.get()
			.uri("http://localhost:8091/division/"+temp)
			.exchangeToMono(this::exchange)
			.doOnNext(System.out::println)
			.doOnError(err -> System.out.println(err.getMessage()))
			;
	}

	private Mono<DivisionResponseDto> exchange(ClientResponse cr) {
		int i = cr.rawStatusCode();
		System.out.println("Division Service Response Status Code : " + i);
		return cr.bodyToMono(DivisionResponseDto.class);
	}

}
