package com.hcl.training.ecommerce.poc.service;

import java.util.List;

import com.hcl.training.ecommerce.poc.model.Product;

/**
 * @author Manjeet Kumar
 *
 *         Sep 1, 2020
 *
 */

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long productId) throws Exception;

	Product addProduct(Product product);

	Product updateProduct(Long productId, Product product);

	void deleteAllProducts();

	void deleteProduct(Long productId) throws Exception;

}
