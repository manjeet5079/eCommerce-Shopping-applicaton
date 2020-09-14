package com.hcl.training.ecommerce.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.ecommerce.poc.model.Cart;
import com.hcl.training.ecommerce.poc.model.CartItem;
import com.hcl.training.ecommerce.poc.service.CartService;

/**
 * @author Manjeet Kumar
 *
 * Sep 4, 2020
 *
 */

@RestController
@RequestMapping("/cart-service")
public class CartController {

	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService cartService;
	//http://localhost:8282/cart-service/cart/101
	@GetMapping(value = "/cart/{id}")
    public Cart getCartById(@PathVariable("id") Long cartId) {
        log.debug("get cart for cart by id: {}", cartId);
        Cart resultcart = cartService.getCartById(cartId);
        log.debug("Cart: {}", resultcart);
        return resultcart;
    }

    @PostMapping(value = "/cart/{id}")
    public Cart addToCart(@PathVariable("id") Long cartId, @RequestBody CartItem cartItem) {
        log.debug("add item to cart by id: {}", cartId);
        Cart resultcart = cartService.addToCart(cartId, cartItem);
        log.debug("Cart: {}", resultcart);
        return resultcart;
    }

    @PostMapping(value = "/cart")
    public Cart addToCart(@RequestBody CartItem cartItem) {
        log.debug("add item to cart without id.");
        Cart resultcart = cartService.addToCart(null, cartItem);
        log.debug("Cart: {}", resultcart);
        return resultcart;
    }
	
}
