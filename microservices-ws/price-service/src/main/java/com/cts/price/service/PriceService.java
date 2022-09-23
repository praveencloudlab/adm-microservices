package com.cts.price.service;

import com.cts.price.entity.Product;

public interface PriceService {

	boolean isProductExit(int id);

	double getPriceById(int id);

	Product save(Product product);

}