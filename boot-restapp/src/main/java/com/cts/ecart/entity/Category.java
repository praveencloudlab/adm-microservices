package com.cts.ecart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "categories")
public class Category {

	@Id
	@GeneratedValue
	private int catId;
	private String catTitle;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatTitle() {
		return catTitle;
	}

	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catTitle=" + catTitle + "]";
	}

}
