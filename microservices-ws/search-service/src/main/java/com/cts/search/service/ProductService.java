package com.cts.search.service;

import java.util.List;
import java.util.Map;

import com.cts.search.entity.Product;

public interface ProductService {

	Product findById(int productId);

	List<Product> findAll();

	Product save(Product product);

	void deleteById(int id);

	void deleteProduct(Product product);

	boolean isProductExists(int productId);

	void inventoryUpdate(int productId,int qty);

	List<Product> findByProductTitleLike(String productTitle);

	List<Product> findByBrand_BrandTitle(String brandName);

	List<Product> findByProductPriceBetween(double startRange, double endRange);

	List<Product> findByProductPriceGreaterThanEqual(double maxPrice);

	List<Product> findByProductPriceLessThanEqual(double minPrice);

	List<Product> findByCategory_CatTitle(String categryTitle);

}
