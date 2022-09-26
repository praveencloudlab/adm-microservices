package com.cts.search.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.search.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>{
	
	//DSL
	List<Brand> findByBrandTitle(String brandTitle);

}
