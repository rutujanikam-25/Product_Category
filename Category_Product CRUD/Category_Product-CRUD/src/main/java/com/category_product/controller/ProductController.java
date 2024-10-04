package com.category_product.controller;

import org.springframework.web.bind.annotation.RestController;

import com.category_product.dao.ProductDao;
import com.category_product.model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api")
public class ProductController {
   @Autowired
	ProductDao dao;
   
   
	
   //localhost:8686/api/products
	@PostMapping("products")
	public String AddProductDB(@RequestBody Product p) {
		p=dao.addPRoduct(p);
		return "add product";
	}
	
	//http://localhost:8686/api/products?page=1&size=0
	 @GetMapping("products")
	    public Page<Product> getPaginatedProducts(Pageable pageable) {
	        return dao.getPaginatedProducts(pageable);
	    }
	
		
		  //localhost:8686/api/products/All
		  
		 @GetMapping("products/All") public ResponseEntity<List<Product>> GetElement() {
		  List<Product> p=dao.viewAllProduct(); return new
		  ResponseEntity<List<Product>>(p,HttpStatus.OK); }
		 
	
	//localhost:8686/api/products/{cid}
	@GetMapping("products/{cid}")
	public Product GetElement11(@PathVariable int cid) {
		Product p=dao.getProductById(cid);
		return p;
	}
	
	//localhost:8686/api/products/{cid}
	@PutMapping("products/{cid}")
	public String UpdateProduct(@PathVariable int cid, @RequestBody Product p) {
		 int j=dao.update(p);
		 if(j>0) {
				return "Product update";
			}else {
				return "Product not present in DB";
			}	
	}
	
	//localhost:8686/api/products/{cid}
	@DeleteMapping("products/{cid}")
	public String DeleteProduct(@PathVariable int cid) {
		int i=dao.deleteProduct(cid);
		if(i>0) {
			return "Product delete";
		}else {
			return "Product not present in DB";
		}
	}
	
	
}
