package com.cts.search.service;

import java.util.List;

import com.cts.search.entity.Category;

public interface CategoryService {

	List<Category> listAllCategories();

	List<Category> filterByCatTitle(String catTitle);

}