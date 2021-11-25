package com.emgc.productservice.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Product {

	@Id
	private Long productId;
	private String productName;
	private Integer productCount;

}
