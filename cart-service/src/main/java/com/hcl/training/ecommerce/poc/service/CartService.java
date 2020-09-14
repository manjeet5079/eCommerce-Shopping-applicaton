package com.hcl.training.ecommerce.poc.service;

import java.util.Optional;

import com.hcl.training.ecommerce.poc.model.Cart;
import com.hcl.training.ecommerce.poc.model.CartItem;

/**
 * @author Manjeet Kumar
 *
 *         Sep 4, 2020
 *
 */
public interface CartService {

	/**
	 * @param id
	 * @return
	 */
	Cart getCartById(Long cartId);

	/**
	 * @param object
	 * @param cartItem
	 * @return
	 */
	Cart addToCart(Long cartId, CartItem cartItem);

}
