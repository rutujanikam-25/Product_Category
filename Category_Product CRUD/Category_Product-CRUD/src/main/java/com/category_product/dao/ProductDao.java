package com.category_product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.category_product.model.Category;
import com.category_product.model.Product;
import com.category_product.repository.ProductRepository;
import com.category_product.service.ProductService;
@Service
public class ProductDao implements ProductService{
	@Autowired
	ProductRepository repos;

	@Override
	public List<Product> viewAllProduct() {
		List<Product> list=repos.findAll();
		return list;
	}
	
	 public Page<Product> getPaginatedProducts(Pageable pageable) {
	        return repos.findAll(pageable);
	    }

	@Override
	public Product addPRoduct(Product p) {
		 Product AddProduct=repos.save(p);
			return AddProduct;
		
	}

	@Override
	public Product getProductById(int productId) {
		Product c=repos.getById(productId);
		return c;
	}

	public int update(Product p) {
		int updateStatus=repos.updateProduct(p.getProduct_Name(),p.getProduct_Price(),p.getProduct_id());
		return updateStatus;
	}
	
	public int deleteProduct(int cid) {
		Product c=repos.getById(cid);
		if(c!=null) {
			repos.delete(c);
			return 1;
		}
		return 0;
	}


}
