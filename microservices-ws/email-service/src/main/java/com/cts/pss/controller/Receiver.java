package com.cts.pss.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {
	
	@Autowired
    private JavaMailSender javaMailSender;
	

	@Bean
	public Queue emailQ() {
		return new Queue("EMAILQ", false);
	}
	
	@RabbitListener(queues = "EMAILQ")
    public void processMessage(Map<String,Object> orderInfo) {
		
        System.out.println("===========> Email-Service:: ****====**** <===========");
		System.out.println(orderInfo);
		System.out.println("===========> Email-Service:: ****====**** <===========");
       

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("richardsforu@gmail.com", "ctsgit@gmail.com", "praveen.somireddy@gmail.com");

        int orderId=(int)orderInfo.get("ORDER_ID");
        LocalDateTime orderDate=(LocalDateTime)orderInfo.get("ORDER_DATE");
       // String productName=(String)orderInfo.get("PRODUCT_NAME");
        String userName=(String)orderInfo.get("USER_ID");
        double total=(double)orderInfo.get("TOTAL");
       // int qty=(int)orderInfo.get("QTY");
        String txrId=(String)orderInfo.get("TRX_ID");
        
        msg.setSubject("Confirmation of order id "+orderId);
        msg.setText("Dear "+userName+" You Order number "+orderId+" is confirmed on "+orderDate+" Transaction ID is "+txrId+" Total Amount : "+total);
        

        javaMailSender.send(msg);
        
		// Logic to send email ...
		
		// searchService.updateInventory((String)fare.get("FLIGHT_NUMBER"),(LocalDate)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
       //call repository and update the fare for the given flight
    }	
	

}
