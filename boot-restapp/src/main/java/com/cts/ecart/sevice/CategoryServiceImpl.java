package com.cts.ecart.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.CategoryDao;
import com.cts.ecart.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> listAllCategories() {
		return categoryDao.findAll();
	}
	
	@Override
	public List<Category> filterByCatTitle(String catTitle){
		return categoryDao.findByCatTitle(catTitle);
		
	}
	
	
}
