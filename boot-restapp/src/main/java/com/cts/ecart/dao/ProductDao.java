package com.cts.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	// DSL : Domain Specific Language
	List<Product> findByProductTitleLike(String productTitle);
	List<Product> findByBrand_BrandTitle(String brandName);
	List<Product> findByProductPriceBetween(double startRange,double endRange);
	List<Product> findByProductPriceGreaterThanEqual(double maxPrice);
	List<Product> findByProductPriceLessThanEqual(double minPrice);
	List<Product> findByCategory_CatTitle(String categryTitle);

}
