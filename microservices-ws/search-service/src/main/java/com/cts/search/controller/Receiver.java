package com.cts.search.controller;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.cts.search.service.ProductService;

@Controller
public class Receiver {
	
	
	

	@Autowired
	private ProductService productService;
	
	@Bean
	public Queue createQueue() {
		return new Queue("INVENTORYQ", false);
	}
	
	

	@RabbitListener(queues = "INVENTORYQ")
	public void inventoryUpdate(Map<String, Object> orderInfo) {
		int productId = (int)orderInfo.get("PRODUCT_ID");
		int qty = (int)orderInfo.get("QTY");

		System.out.println("=============================================================");
		System.out.println("UPDATING INVENTORY FROM PRODUCT-SERVICE");
		productService.inventoryUpdate(productId, qty);
		System.out.println("INVENTORY UPDATE SUCCESS");
		System.out.println("=============================================================");

	}

}
