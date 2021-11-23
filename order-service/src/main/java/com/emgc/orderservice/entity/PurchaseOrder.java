package com.emgc.orderservice.entity;

import com.emgc.orderservice.dto.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private Integer id;
	private String productId;
	private Integer userId;
	private Integer amount;
	private OrderStatus status;

}
