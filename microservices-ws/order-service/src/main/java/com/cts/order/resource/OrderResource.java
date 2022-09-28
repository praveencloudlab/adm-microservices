package com.cts.order.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.order.entity.Order;
import com.cts.order.service.OrderServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrderResource {
	
	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/{user}")
	public List<Order> placeOrder(@PathVariable("user")String user){
		return orderService.placeOrder(user);
	}
}
