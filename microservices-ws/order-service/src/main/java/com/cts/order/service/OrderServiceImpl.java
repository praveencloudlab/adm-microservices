package com.cts.order.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.order.controller.Sender;
import com.cts.order.dao.OrderDao;
import com.cts.order.dao.UserDao;
import com.cts.order.entity.Order;
import com.cts.order.entity.Product;
import com.cts.order.entity.UserInfo;
import com.cts.order.model.ItemLine;
@Service
public class OrderServiceImpl {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private Sender sender;
	
	private RestTemplate cartTemplate=new RestTemplate();
	private RestTemplate productTemplate=new RestTemplate();
	protected static SecureRandom random = new SecureRandom();


	private final String CART_URL="http://localhost:8083/api/v1/cart";

	public List<Order> placeOrder(String user) {
		// read items from cart service for specified user
		ItemLine[] cartItems = cartTemplate.getForObject(CART_URL+"/"+user, ItemLine[].class);
		UserInfo userInfo = userDao.findById(user).orElse(null);
		List<Order> orders=new ArrayList<>();
	
		for(ItemLine itemLine:cartItems) {
			
			Product product=productTemplate.getForObject("http://localhost:8082/api/v1/products/"+itemLine.getItem().getId(), Product.class);
		 
			
		   String transactionNumber = Math.abs(random.nextLong())+"";

			Order order=new Order();
			
			order.setOrderDate(LocalDateTime.now());
			order.setProduct(product);
			order.setpStatus("SUCCESS");
			order.setQty(itemLine.getQty());
			order.setTotal(itemLine.getItem().getItemTotal());
			order.setTrxId(transactionNumber);
			order.setUserInfo(userInfo);
			
			orders.add(order);  // save the order
			
			orderDao.save(order);
			
			// Clear cart items : REST CALL to the cart-service
			cartTemplate.delete(CART_URL+"/"+user);
			
			
			Map<String, Object> orderInfo=new HashMap<String, Object>();
			Map<String, Object> inventoryInfo=new HashMap<String, Object>();
			
			inventoryInfo.put("PRODUCT_ID", product.getProductId());
			inventoryInfo.put("QTY", itemLine.getQty());

			orderInfo.put("ORDER_ID", order.getOrderId());
			orderInfo.put("ORDER_DATE",order.getOrderDate());
			orderInfo.put("TRX_ID", order.getTrxId());
			orderInfo.put("QTY", order.getQty());
			orderInfo.put("PRODUCT_PRICE", product.getProductPrice());
			orderInfo.put("TOTAL", order.getTotal());
			orderInfo.put("USER_ID", userInfo.getUserId());
			orderInfo.put("PRODUCT_NAME", product.getProductTitle());
			
			// Send order information to the INVENTORYQ 
			 sender.updateInventory(inventoryInfo);
		
			//send order information to the EMAIL SERVICE
			 sender.sendEmail(orderInfo);
		}
		
		return orders;
	}
	
	
	 public void updateInventory(int productId,int qty) {
			//Product product=productTemplate.getForObject("http://localhost:8082/api/v1/products/"+productId, Product.class);
			//product.setProductQty(product.getProductQty()-qty);
	 }
	
	
	
	
	
	
	
	
	
}
