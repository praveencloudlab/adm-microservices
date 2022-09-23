package com.example.demo.controller;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Receiver {
	
	
	@RabbitListener(queues = "Q1")
	public void f1(Map<String, Object> details) {
		System.out.println("-----------------------------");
		System.out.println(details.get("ORDER_ID"));
		System.out.println(details.get("PRODUCT_ID"));
		System.out.println(details.get("ORDER_DATE"));
		System.out.println(details.get("QTY"));
		System.out.println(details.get("USER_ID"));
		System.out.println("-----------------------------");
		
		
	}

}
