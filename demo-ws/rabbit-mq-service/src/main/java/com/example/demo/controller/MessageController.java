package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.MessageServiceImpl;

@Controller
public class MessageController {
	
	@Autowired
	private MessageServiceImpl ms;
	
	@GetMapping
	public String f1() {
		ms.f1();
		return "Queue message processed";
	}
	
	
	
	
	

}
