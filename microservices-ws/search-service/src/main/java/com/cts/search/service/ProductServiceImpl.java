package com.cts.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.search.dao.ProductDao;
import com.cts.search.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product findById(int productId) {
		return productDao.findById(productId).orElse(null);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public void deleteById(int productId) {
		productDao.deleteById(productId);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);

	}

	@Override
	public boolean isProductExists(int productId) {
		return productDao.existsById(productId);
	}

	// Inventory Update
	@Override
	public void inventoryUpdate(int productId, int productQty) {

		Product product = productDao.findById(productId).orElse(null);

		if (product != null) {
			product.setProductQty((product.getProductQty() - productQty));
			productDao.save(product);
		}
	}

	@Override
	public List<Product> findByProductTitleLike(String productTitle) {
		return productDao.findByProductTitleLike(productTitle);
	}

	@Override
	public List<Product> findByBrand_BrandTitle(String brandName) {
		return productDao.findByBrand_BrandTitle(brandName);
	}

	@Override
	public List<Product> findByProductPriceBetween(double startRange, double endRange) {
		return productDao.findByProductPriceBetween(startRange, endRange);
	}

	@Override
	public List<Product> findByProductPriceGreaterThanEqual(double maxPrice) {
		return productDao.findByProductPriceGreaterThanEqual(maxPrice);
	}

	@Override
	public List<Product> findByProductPriceLessThanEqual(double minPrice) {
		return productDao.findByProductPriceLessThanEqual(minPrice);
	}

	@Override
	public List<Product> findByCategory_CatTitle(String categryTitle) {
		return productDao.findByCategory_CatTitle(categryTitle);
	}
}
