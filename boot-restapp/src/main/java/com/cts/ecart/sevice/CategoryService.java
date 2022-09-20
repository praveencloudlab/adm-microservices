package com.cts.ecart.sevice;

import java.util.List;

import com.cts.ecart.entity.Category;

public interface CategoryService {

	List<Category> listAllCategories();

	List<Category> filterByCatTitle(String catTitle);

}