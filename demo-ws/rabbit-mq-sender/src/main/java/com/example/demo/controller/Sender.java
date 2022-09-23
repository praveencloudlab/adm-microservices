package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Sender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public Sender() {
		rabbitTemplate=new RabbitTemplate();
		System.out.println(">> Rabbit MQ Object:: "+rabbitTemplate);
	}
	
	@Bean
	public Queue createQueue() {
		System.out.println(">>> Creating queue Q1");
		return new Queue("Q1",false);
	}
	
	@Bean
	public void sendMessage() {
		System.out.println(">>> sending message to Queue");
		
		Map<String, Object> orderDetails=new HashMap<>();
		
		orderDetails.put("ORDER_ID", "ABC000808304381");
		orderDetails.put("USER_ID", "praveen@abc.com");
		orderDetails.put("ORDER_DATE", LocalDateTime.now());
		orderDetails.put("QTY", 5);
		orderDetails.put("PRODUCT_ID", 19876);
		
		
		 rabbitTemplate.convertAndSend("Q1",orderDetails);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
