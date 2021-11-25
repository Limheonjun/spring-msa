package com.emgc.multiplyservice.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Number {

	@Id
	private Long numberId;
	private Integer number;

}
