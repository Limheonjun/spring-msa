package com.emgc.integrationservice.dto;

import lombok.Data;

@Data
public class IntegrationRequestDto {

	private Integer operand;

	public IntegrationRequestDto(int input) {
		operand = input;
	}

}
