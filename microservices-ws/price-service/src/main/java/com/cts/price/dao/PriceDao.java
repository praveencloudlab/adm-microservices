package com.cts.price.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.price.entity.Product;

public interface PriceDao extends JpaRepository<Product, Integer>{

}
