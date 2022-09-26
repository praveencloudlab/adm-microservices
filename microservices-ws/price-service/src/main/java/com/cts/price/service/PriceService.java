package com.cts.price.service;

import com.cts.price.entity.Product;

public interface PriceService {

	boolean isProductExit(int id);

	double getPriceById(int id);

	double calculateDiscount(String couponCode,int productId);

	Product save(Product product);

}