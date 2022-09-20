package com.cts.ecart.sevice;

import java.util.List;

import com.cts.ecart.entity.Brand;

public interface BrandService {

	List<Brand> listAllBrands();

	List<Brand> filterByBrandTitle(String brandTitle);

}