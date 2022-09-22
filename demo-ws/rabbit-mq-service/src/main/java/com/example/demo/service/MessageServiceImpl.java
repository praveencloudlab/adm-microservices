package com.example.demo.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {
	
	@Autowired
	private RabbitTemplate rt;
	
	
	@Bean
	public Queue createQueue() {
		System.out.println(">>>>>>>>> creating rammit MQ Queue <<<<<<<<");
		return new Queue("Q1", false);
	}
	
	
	public void f1() {
		System.out.println(">>>> Written to Queue..");
		rt.convertAndSend("Q1","This is my secnd JMS message");
	}

}
