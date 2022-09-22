package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/app2")
public class App2Resource {
	
	
	
	/*
	 * Service communications : 2 classes
	 *    1. RestTemplte
	 *    2. WebClient
	 */
	
	
	 private RestTemplate rt;
	 
	 @Autowired
	 public App2Resource() {
		rt=new RestTemplate();
	}
	 
	 
	 private final String BASE_URL="http://localhost:8081/api/app1";
	
	@GetMapping
	public String test() {
		String message=rt.getForObject(BASE_URL, String.class);

		return "App2 message - "+message;
	}
	
	
	@GetMapping("/getData")
	public Object getData() {
		Object obj=rt.getForObject(BASE_URL+"/product", Object.class);
		return obj;
	}
	
	@GetMapping("/info")
	public Object[] getInfo() {
		Object[] objects = rt.getForObject(BASE_URL+"/products", Object[].class);
		return objects;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
