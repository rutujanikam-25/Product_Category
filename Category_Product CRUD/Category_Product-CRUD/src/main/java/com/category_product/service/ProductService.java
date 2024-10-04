package com.category_product.service;

import java.util.List;

import com.category_product.model.Product;

public interface ProductService {
	 public List<Product> viewAllProduct();
     public Product addPRoduct(Product p);
     public Product getProductById(int productId);
    

}
