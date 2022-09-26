package com.cts.search.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.search.entity.Brand;
import com.cts.search.entity.Category;
import com.cts.search.entity.Product;
import com.cts.search.service.BrandService;
import com.cts.search.service.CategoryService;
import com.cts.search.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Product> listAllProducts(){
		return productService.findAll();
	}
	
	@GetMapping("/{productId}")
	public Product findById(@PathVariable("productId")int productId) {
		return productService.findById(productId);
	}
	
	@GetMapping("/filter/brand/{brandName}")
	public List<Product> filterProductsByBrand(@PathVariable String brandName) {
		return productService.findByBrand_BrandTitle(brandName);
	}
	
	@GetMapping("/filter/title/{productTitle}")
	public List<Product> filterProductsByTitle(@PathVariable String productTitle) {
		return productService.findByProductTitleLike("%"+productTitle+"%");
	}
	
	@GetMapping("/filter/price/{startRange}/{endRange}")
	public List<Product> filterProductsByPriceRange(@PathVariable double startRange,@PathVariable double endRange) {
		return productService.findByProductPriceBetween(startRange, endRange);
	}
	
	
	@GetMapping("/filter/price/min/{minPrice}")
	public List<Product> filterProductsByMinPrice(@PathVariable double minPrice) {
		return productService.findByProductPriceLessThanEqual(minPrice);
	}
	
	
	@GetMapping("/filter/price/max/{maxPrice}")
	public List<Product> filterProductsByMaxPrice(@PathVariable double maxPrice) {
		return productService.findByProductPriceGreaterThanEqual(maxPrice);
	}
	
	@GetMapping("/filter/brands")
	List<Brand> findAllBrands(){
		return  brandService.listAllBrands();
	}
	
	@GetMapping("/filter/brands/{brandTitle}")
	List<Brand> filterByTitle(@PathVariable String brandTitle){
			return brandService.filterByBrandTitle(brandTitle);
	}
	
	@GetMapping("/filter/category")
	List<Category> listAllCategories(){
		return categoryService.listAllCategories();
	}
	
	@GetMapping("/filter/category/{categoryTitle}")
	List<Category> filterCategoriesByTitle(@PathVariable String categoryTitle){
		return categoryService.filterByCatTitle(categoryTitle);
	}
}
