package com.cts.cart.dao;

import java.util.List;

import com.cts.cart.entity.ItemLine;

public interface CartRepository {

	ItemLine save(String user, ItemLine itemLine);

	List<ItemLine> findAll(String user);

	void clear(String user);

}