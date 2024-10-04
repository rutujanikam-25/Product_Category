package com.category_product.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	private int Category_id;
	
	 @Column(nullable = false)
	    private String category_name;

	    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	    private List<Product> products;

		public int getCategory_id() {
			return Category_id;
		}

		public void setCategory_id(int category_id) {
			Category_id = category_id;
		}

		public String getCategory_name() {
			return category_name;
		}

		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public Category(int category_id, String category_name, List<Product> products) {
			super();
			Category_id = category_id;
			this.category_name = category_name;
			this.products = products;
		}

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Category [Category_id=" + Category_id + ", category_name=" + category_name + ", products="
					+ products + "]";
		}
	    
	    
	    

}
