package com.cts.price.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.price.entity.Product;
import com.cts.price.service.PriceService;

@RestController
@CrossOrigin
@RequestMapping("/api/price")
public class PriceServiceResource {
	
	@Autowired
	private PriceService priceService;

	@GetMapping("/{id}")
	public double getPrice(@PathVariable("id") int id) {
		return priceService.getPriceById(id);
	}
	
	@PutMapping("/{id}/{price}")
	public double updatePrice(@PathVariable("id") int id,
							  @PathVariable("price")double price) {
		
		if(priceService.isProductExit(id)) {
			Product p=new Product();
			p.setProductId(id);
			p.setProductPrice(price);
			priceService.save(p);
			return price;
		}
			return 0.0;
	}
}
