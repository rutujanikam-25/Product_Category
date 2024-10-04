package com.category_product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.category_product.model.*;

import com.category_product.dao.CategoryDao;
import com.category_product.dao.ProductDao;

@RestController
@RequestMapping("/api")
public class CategoryController {

	
	@Autowired
	CategoryDao dao;
	
	//localhost:8686/api/categories
	@PostMapping("categories")
	public Category AddCategoriseDB(@RequestBody Category c) {
		Category category= dao.addCategory(c);
		return category;
	}
	
	//http://localhost:8686/api/categories?page=1&size=0
		 @GetMapping("categories")
		    public Page<Category> getPaginatedCategory(Pageable pageable) {
		        return dao.getPaginatedCategory(pageable);
		    }
		
	
	//localhost:8686/api/categories
	@GetMapping("categories/All")
	public ResponseEntity<List<Category>> GetElement() {
		List<Category> p=dao.viewAllCategory();
		return new ResponseEntity<List<Category>>(p,HttpStatus.OK);
	}
	
	//localhost:8686/api/categories/{cid}
	@GetMapping("categories/{cid}")
	public Category GetElement11(@PathVariable int cid) {
		Category c=dao.getCategoryById(cid);
		return c;
	}
	
	
	//localhost:8686/api/categories/{cid}
	@PutMapping("categories/{cid}")
	public String UpdateCategory(@PathVariable int cid, @RequestBody Category c) {
		 int j=dao.update(c);
		 if(j>0) {
				return "Category update";
			}else {
				return "category not present in DB";
			}	
	}
	
	
	//localhost:8686/api/categories/{cid}
	@DeleteMapping("categories/{cid}")
	public String DeleteCategory(@PathVariable int cid) {
		int i=dao.deleteCategory(cid);
		if(i>0) {
			return "Product delete";
		}else {
			return "Product not present in DB";
		}
	}
	
}
