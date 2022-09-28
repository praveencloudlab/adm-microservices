package com.cts.cart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cart.entity.Item;
import com.cts.cart.entity.ItemLine;
import com.cts.cart.entity.Product;
import com.cts.cart.service.CartService;

@RestController
@RequestMapping("/api/v1/cart/{user}")
public class CartResource {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/{productId}/{qty}")
	public ItemLine addToCart(@PathVariable("user")String user,@PathVariable("productId")int productId,@PathVariable("qty")int qty) {
		//itemLine.getItem().setItemTotal(itemLine.getQty()*itemLine.getItem().getPrice());		
		Product product = cartService.findProduct(productId);
		ItemLine itemLine=new ItemLine();
		Item item=new Item(product.getProductId(), product.getProductTitle(), product.getProductPrice());
		item.setItemTotal(product.getProductPrice()*qty);
		itemLine.setItem(item);
		itemLine.setQty(qty);
		return cartService.save(user, itemLine);
	}
	
	@GetMapping
	public List<ItemLine> getCartItems(@PathVariable("user")String user){
		return cartService.findAll(user);
	}
	
	@DeleteMapping
	public void clearCart(@PathVariable("user")String user) {
		cartService.clear(user);
	}
}
