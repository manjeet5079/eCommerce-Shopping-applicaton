package com.hcl.training.ecommerce.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.training.ecommerce.poc.model.Product;

/**
 * @author Manjeet Kumar
 *
 *         Sep 1, 2020
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * @param productId
	 * @return
	 */
	Product findByProductId(Long productId);

	

	// String addProduct(Product product);

	// String updateProduct(Product product);

}
