package com.emgc.integrationservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emgc.integrationservice.dto.DivisionResponseDto;
import com.emgc.integrationservice.dto.IntegrationResponseDto;
import com.emgc.integrationservice.dto.MultiplyResponseDto;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class IntegrationService {

	private final DivisionService divisionService;
	private final MultiplyService multiplyService;

	// F1 : a -> Mono<b>
	// F2 : a -> b
	//
	// flatMap과 map 모두 인자로 받은 함수의 반환값을 결과적으로 Publisher타입으로 감싸서 반환
	//
	// 차이점
	// flatMap : 결과값을 한꺼풀 벗겨 publisher로 만듦
	// flatMap(F1) => F1은 a를 입력받아 Mono<b>를 리턴, 하지만 flatMap에 의해 Mono<b>에서 값 b만 추출하여 다시 Mono로 감싸서 반환
	// map : 결과값을 그대로 publisher로 만듦
	// map(F1) => F1은 a를 입력받아 Mono<b>를 리턴, map은 반환값을 publisher타입으로 감싸기에 Mono<Mono<b>>가 되어서 반환
	// map(F2) => F2는 a를 입력받아 b를 반환, map은 있는 그대로 반환받은 b를 Mono<b>로 듦
	public Mono<IntegrationResponseDto> doOperate(int input) {
		//특정 객체에 데이터를 채워야 하는 경우 Context객체를 만들어서 Publisher의 인자로 주고
		//map이나 flatMap의 인자로 주는 함수를 통해서 해당 Context를 받아 데이터를 채우고 다시 반환하도록 하는 방법도 있음
		IntegrationResponseDto dto = new IntegrationResponseDto();

		return Mono.just(input)

				.doOnNext(dto::setOperand)
				//입력값 : publisher에서 꺼낸 내부 데이터가 입력값, doMultiply의 반환값은 Mono<MultiplyResponseDto>이고, 여기서 MultiplyResponseDto만 꺼내서 다시 Mono로 감싸서 반환
				//Mono<MultiplyResponseDto>
				.flatMap(multiplyService::doMultiply)

				//Mono<MultiplyResponseDto>에서 MultiplyResponseDto가 입력값이 되고, getNumber를 통해 Integer타입을 반환하지만
				//map의 정의에 의해 다시 Mono로 감싸짐
				//Mono<Integer>
				.map(MultiplyResponseDto::getNumber)

				.doOnNext(dto::setMultiplyResult)

				//입력값 : Integer, 반환값 : Mono<DivisionResponseDto>
				//Mono<Mono<DivisionResponseDto>>가 되지 않도록 flatMap을 통해 Mono를 한꺼풀 벗겨내고 반환
				//Mono<DivisionResponseDto>
				.flatMap(divisionService::doDivision)

				//입력값 : DivisionResponseDto, 반환값 : Integer
				//map에 의해 반환된 Integer는 다시 Mono로 감싸짐
				//Mono<Integer>
				.map(DivisionResponseDto::getNumber)

				.doOnNext(dto::setDivisionResult)

				//입력값 : Integer, 반환값 : IntegrationResponseDto
				//map에 의해 입력된 Integer는 다시 Mono로 감싸짐
				//Mono<IntegrationResponseDto>
				.map(val -> {
					dto.setInfoId(UUID.randomUUID().toString());
					return dto;
				});
	}

}
