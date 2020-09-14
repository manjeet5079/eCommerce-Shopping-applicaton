package com.hcl.training.ecommerce.poc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.ecommerce.poc.dao.CartRepository;
import com.hcl.training.ecommerce.poc.model.Cart;
import com.hcl.training.ecommerce.poc.model.CartItem;

/**
 * @author Manjeet Kumar
 *
 *         Sep 4, 2020
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart getCartById(Long cartId) {
		Cart resultCart = cartRepository.findByCartId(cartId);
		return resultCart;
	}

	/////new changes
	@Override
	public Cart addToCart(Long cartId, CartItem cartItem) {
		float total = 0f;
		 Cart cart = new Cart();
		System.out.println("cartId::" + cartId);
		System.out.println("cartItem::" + cartItem);
		if ((cartId == null)) {
			if(cartItem.getCartItemId()==null) {
				long generatedId = UUID.randomUUID().getMostSignificantBits();
				cartItem.setCartItemId(generatedId);
				System.out.println("cartItem::"+cartItem);
			System.out.println("New CartId"+UUID.randomUUID().getMostSignificantBits());
			 cart = createCart(UUID.randomUUID().getMostSignificantBits(), cartItem);
			 System.out.println("New cart::"+cart);
			}else {
				System.out.println("New CartId"+UUID.randomUUID().getMostSignificantBits());
				 cart = createCart(UUID.randomUUID().getMostSignificantBits(), cartItem);
				 System.out.println("New cart::"+cart);
			}
		} else {
			 cart = getCartById(cartId);
			System.out.println("cart::" + cart);
			if (cart == null) {
				cart = createCart(cartId, cartItem);
				System.out.println("cart"+cart);
			} else {
				 cart.getCartItems().add(cartItem);
			}
		}

		for (CartItem item : cart.getCartItems()) {
			total += item.getCartItemPrice();
			System.out.println("total::"+total);
		}

		cart.setCartTotal(total);
		System.out.println("Final cart::"+cart);
		Cart resultSaveCart = cartRepository.save(cart);
		System.out.println("resultSaveCart::"+resultSaveCart);
		return resultSaveCart;

	}

	private Cart createCart(Long cartId, CartItem cartItem) {
		List<CartItem> cartItems = new ArrayList<CartItem>();
		cartItems.add(cartItem);
		Cart cart = new Cart(cartId, cartItems, cartItem.getCartItemPrice());
		// return cart;
		// Cart cart =new Cart();
		return cart;
	}

}
