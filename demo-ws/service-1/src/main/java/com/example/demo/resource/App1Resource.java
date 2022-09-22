package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
@RequestMapping("/api/app1")
public class App1Resource {
	
	
	@GetMapping
	public String greet() {
		return "Good Morning";
	}
	
	@GetMapping("/product")
	public Product getProduct() {
		return new Product(10, "Pen", 76, "red Ink");
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		 Product p1=new Product(10, "Pen", 76, "red Ink");
		 Product p2=new Product(11, "Bok", 3222, "Java Book");
		 Product p3=new Product(12, "Toy", 987, "Remote toy car");
		 
		 List<Product> prods = Arrays.asList(p1,p2,p3);
		
		return prods;	
	}

}
