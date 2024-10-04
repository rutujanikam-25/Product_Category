package com.category_product.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
	private int product_id;
    private String Product_Name;
    private double Product_Price;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public double getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(double product_Price) {
		Product_Price = product_Price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_id, String product_Name, double product_Price, Category category) {
		super();
		this.product_id = product_id;
		Product_Name = product_Name;
		Product_Price = product_Price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", Product_Name=" + Product_Name + ", Product_Price="
				+ Product_Price + ", category=" + category + "]";
	}
    
    
    
}
