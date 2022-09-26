package com.cts.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.search.dao.BrandDao;
import com.cts.search.entity.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> listAllBrands() {
		return brandDao.findAll();
	}

	@Override
	public List<Brand> filterByBrandTitle(String brandTitle) {
		return brandDao.findByBrandTitle(brandTitle);
	}

}
