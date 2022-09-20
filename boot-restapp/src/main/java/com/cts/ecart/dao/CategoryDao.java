package com.cts.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	//DSL
	List<Category> findByCatTitle(String catTitle);

}
