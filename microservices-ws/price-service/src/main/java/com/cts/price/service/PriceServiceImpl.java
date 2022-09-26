package com.cts.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.price.dao.PriceDao;
import com.cts.price.entity.Product;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceDao priceDao;

	
	public double calculateDiscount(String couponCode,int productId) {
		// logic to calculate discount price for the given product ID
		return 0.0;
	}
	
	
	
	
	public boolean isProductExit(int id) {
		return priceDao.existsById(id);
	}
	
	@Override
	public double getPriceById(int id) {
		
		Product prod = priceDao.findById(id).orElse(null);
		if (prod != null)
			return prod.getProductPrice();
		else
			return 0.0;
	}
	
	
	@Override
	public Product save(Product product) {
		return priceDao.save(product);
	}
}
