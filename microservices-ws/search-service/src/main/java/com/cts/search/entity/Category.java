package com.cts.search.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "categories")
public class Category {

	@Id
	@GeneratedValue
	private int CatId;
	private String catTitle;

	public int getCatId() {
		return CatId;
	}

	public void setCatId(int catId) {
		CatId = catId;
	}

	public String getCatTitle() {
		return catTitle;
	}

	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}

	@Override
	public String toString() {
		return "Category [CatId=" + CatId + ", catTitle=" + catTitle + "]";
	}

}
