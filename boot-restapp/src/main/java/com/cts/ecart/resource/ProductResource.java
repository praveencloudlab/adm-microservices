package com.cts.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Product;
import com.cts.ecart.sevice.BrandService;
import com.cts.ecart.sevice.CategoryService;
import com.cts.ecart.sevice.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	public List<Product> listAllProducts(){
		return productService.listAllProducts();
	}
	
	@GetMapping("/filter/brand/{brandName}")
	public List<Product> filterProductsByBrand(@PathVariable String brandName) {
		return productService.filterByBrandName(brandName);
	}
	
	@GetMapping("/filter/title/{productTitle}")
	public List<Product> filterProductsByTitle(@PathVariable String productTitle) {
		return productService.findAllProductsByTitle("%"+productTitle+"%");
	}
	
	@GetMapping("/filter/price/{startRange}/{endRange}")
	public List<Product> filterProductsByPriceRange(@PathVariable double startRange,@PathVariable double endRange) {
		return productService.filterByPriceRance(startRange, endRange);
	}
	
	
	@GetMapping("/filter/price/min/{minPrice}")
	public List<Product> filterProductsByMinPrice(@PathVariable double minPrice) {
		return productService.filterByMinPrice(minPrice);
	}
	
	
	@GetMapping("/filter/price/max/{maxPrice}")
	public List<Product> filterProductsByMaxPrice(@PathVariable double maxPrice) {
		return productService.filterByMaxPrice(maxPrice);
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
