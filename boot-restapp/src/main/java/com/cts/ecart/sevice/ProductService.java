package com.cts.ecart.sevice;

import java.util.List;

import com.cts.ecart.entity.Product;

public interface ProductService {

	Product findById(int productId);

	List<Product> findAllProductsByTitle(String productTitle);

	List<Product> listAllProducts();

	List<Product> filterByBrandName(String brandName);

	List<Product> filterByPriceRance(double startRange, double endRange);

	List<Product> filterByMinPrice(double minPrice);

	List<Product> filterByMaxPrice(double maxPrice);

	List<Product> filterProductsByCategory(String categoryName);

}