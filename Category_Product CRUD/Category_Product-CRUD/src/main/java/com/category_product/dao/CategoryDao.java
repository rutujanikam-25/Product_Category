package com.category_product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.category_product.model.Category;
import com.category_product.model.Product;
import com.category_product.repository.CategoryRepository;
import com.category_product.service.CategoryService;

@Service
public class CategoryDao implements CategoryService {
    @Autowired
	CategoryRepository repos;
	
	@Override
	public List<Category> viewAllCategory() {
		List<Category> list=repos.findAll();
		return list;
	}
	
	 public Page<Category> getPaginatedCategory(Pageable pageable) {
	        return repos.findAll(pageable);
	    }

	@Override
	public Category addCategory(Category category) {
		 Category AddCategory=repos.save(category);
		return AddCategory;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category c=repos.getById(categoryId);
		return c;
	}
	
	public int update(Category c) {
		int updateStatus=repos.updateCategory(c.getCategory_name(),c.getCategory_id());
		return updateStatus;
	}
	
	public int deleteCategory(int cid) {
		Category c=repos.getById(cid);
		if(c!=null) {
			repos.delete(c);
			return 1;
		}
		return 0;
	}

	

	
}
