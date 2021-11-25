package com.emgc.userservice.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

	@Id
	private Long userId;
	private String userName;
	private Integer money;

}
