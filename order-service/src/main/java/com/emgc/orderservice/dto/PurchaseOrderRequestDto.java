package com.emgc.orderservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrderRequestDto {

	private Integer userId;
	private String productId;

}
