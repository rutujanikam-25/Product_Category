package com.category_product.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.category_product.model.Product;

import jakarta.transaction.Transactional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	 Page<Product> findAll(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query(value="update Product c set c.Product_Name=:p1, c.Product_Price=:p2 where c.product_id=:p3",nativeQuery=true)
    public int updateProduct(@Param("p1")String cname,
		                   @Param("p2")double cprice,
		                   @Param("p3")long cid);
	
}
