package com.category_product.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.category_product.model.Category;
import com.category_product.model.Product;

import jakarta.transaction.Transactional;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Page<Category> findAll(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query(value="update Category c set c.category_name=:p1 where c.Category_id=:p2",nativeQuery=true)
    public int updateCategory(@Param("p1")String cname,
		                   @Param("p2")int cid);
        
}
