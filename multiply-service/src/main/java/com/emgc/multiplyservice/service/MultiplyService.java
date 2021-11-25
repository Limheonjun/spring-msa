package com.emgc.multiplyservice.service;

import org.springframework.stereotype.Service;

import com.emgc.multiplyservice.dto.MultiplyRequestDto;
import com.emgc.multiplyservice.dto.MultiplyResponseDto;
import com.emgc.multiplyservice.repository.NumberRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MultiplyService {

	private final NumberRepository repository;

	public Mono<MultiplyResponseDto> doMultiply(int operand) {
		return repository.findById(1L)
							.map(number -> number.getNumber() * operand)
							.map(this::toDto);
	}

	private MultiplyResponseDto toDto(Number number) {
		return new MultiplyResponseDto(number.intValue());
	}

}
