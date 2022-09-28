package com.cts.cart.service;

import java.util.List;

import com.cts.cart.entity.ItemLine;
import com.cts.cart.entity.Product;

public interface CartService {

	ItemLine save(String user, ItemLine itemLine);

	List<ItemLine> findAll(String user);

	void clear(String user);
	
	Product findProduct(int productId);

}
