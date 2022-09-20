package com.cts.ecart.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.ProductDao;
import com.cts.ecart.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao prodDao;
	
	
	
	@Override
	public Product findById(int productId) {
		return prodDao.findById(productId).orElse(null);
	}
	
	@Override
	public List<Product> findAllProductsByTitle(String productTitle) {
		return prodDao.findByProductTitleLike(productTitle);
	}
	
	@Override
	public List<Product> listAllProducts(){
		return prodDao.findAll();
	}
	
	@Override
	public List<Product> filterByBrandName(String brandName) {
		return prodDao.findByBrand_BrandTitle(brandName);
	}
	
	@Override
	public List<Product> filterByPriceRance(double startRange,double endRange){
		return prodDao.findByProductPriceBetween(startRange, endRange);
	}
	
	@Override
	public List<Product> filterByMinPrice(double minPrice){
		return prodDao.findByProductPriceLessThanEqual(minPrice);
	}
	
	@Override
	public List<Product> filterByMaxPrice(double maxPrice){
		return prodDao.findByProductPriceGreaterThanEqual(maxPrice);
	}
	
	@Override
	public List<Product> filterProductsByCategory(String categoryName){
		return prodDao.findByCategory_CatTitle(categoryName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
