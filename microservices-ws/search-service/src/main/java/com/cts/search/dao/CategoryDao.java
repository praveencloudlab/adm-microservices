package com.cts.search.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.search.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	//DSL
	List<Category> findByCatTitle(String catTitle);

}
