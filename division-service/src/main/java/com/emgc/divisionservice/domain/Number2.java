package com.emgc.divisionservice.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Number2 {

	@Id
	private Long numberId;
	private Integer number;

}
