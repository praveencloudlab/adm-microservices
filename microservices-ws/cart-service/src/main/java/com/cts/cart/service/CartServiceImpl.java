package com.cts.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.cart.dao.CartRepository;
import com.cts.cart.entity.ItemLine;
import com.cts.cart.entity.Product;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	private RestTemplate restTemplate=new RestTemplate();
	
	
	@Override
	public ItemLine save(String user, ItemLine itemLine) {
		return cartRepository.save(user, itemLine);
	}

	@Override
	public List<ItemLine> findAll(String user) {
		return cartRepository.findAll(user);
	}

	@Override
	public void clear(String user) {
		cartRepository.clear(user);	
	}

	@Override
	public Product findProduct(int productId) {
		return restTemplate.getForObject("http://localhost:8082/api/v1/products/"+productId, Product.class);
	}
	

}
