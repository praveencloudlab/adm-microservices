package com.cts.search.service;

import java.util.List;

import com.cts.search.entity.Brand;

public interface BrandService {

	List<Brand> listAllBrands();

	List<Brand> filterByBrandTitle(String brandTitle);

}