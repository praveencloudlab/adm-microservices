package com.cts.cart.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cart.dao.CartRepository;
import com.cts.cart.entity.ItemLine;

@RestController
@RequestMapping("/api/v1/cart/{user}")
public class Cartresource {
	@Autowired
	private CartRepository cartRepository;
	
	@PostMapping
	public ItemLine addToCart(@PathVariable("user")String user,@RequestBody ItemLine itemLine) {
		itemLine.getItem().setItemTotal(itemLine.getQty()*itemLine.getItem().getPrice());
		
		System.out.println(">>>>> Total: "+itemLine.getQty()*itemLine.getItem().getPrice());
		
		return cartRepository.save(user, itemLine);
	}

}
