package com.emgc.divisionservice.service;

import org.springframework.stereotype.Service;

import com.emgc.divisionservice.dto.DivisionResponseDto;
import com.emgc.divisionservice.repository.NumberRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DivisionService {

	private final NumberRepository repository;

	public Mono<DivisionResponseDto> doDivision(int operand) {
		return repository.findById(1L)
							.map(number -> operand / number.getNumber())
							.map(this::toDto);
	}

	private DivisionResponseDto toDto(Number number) {
		return new DivisionResponseDto(number.intValue());
	}

}
