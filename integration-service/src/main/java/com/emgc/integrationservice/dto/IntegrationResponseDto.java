package com.emgc.integrationservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntegrationResponseDto {

	private String infoId;
	private Integer operand;
	private Integer multiplyResult;
	private Integer divisionResult;

}
