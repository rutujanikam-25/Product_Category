package com.category_product.service;

import java.util.List;

import com.category_product.model.Category;

public interface CategoryService {
	 public List<Category> viewAllCategory();
     public Category addCategory(Category category);
     public Category getCategoryById(int categoryId);
     
}
