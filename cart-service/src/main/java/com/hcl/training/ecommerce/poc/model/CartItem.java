package com.hcl.training.ecommerce.poc.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Manjeet Kumar
 *
 *         Sep 4, 2020
 *
 */

@Entity
@Table(name = "CART_ITEM")
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue//(strategy = GenerationType.AUTO)
	@Column(name = "CARTITEM_ID")
	private Long cartItemId;

	private String cartItemName;

	private float cartItemPrice;


	//@JsonIgnore
    @JoinColumn(name = "cartId")
	@ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	Cart cart;

	public CartItem() {
	}

	/**
	 * @param cartItemId
	 * @param cartItemName
	 * @param cartItemPrice
	 */
	public CartItem(Long cartItemId, String cartItemName, float cartItemPrice) {
		super();
		this.cartItemId = cartItemId;
		this.cartItemName = cartItemName;
		this.cartItemPrice = cartItemPrice;
	}

	
	
	/**
	 * @return the cart
	 */
	/*
	 * public Cart getCart() { return cart; }
	 */

	/**
	 * @param cart the cart to set
	 */
	/*
	 * public void setCart(Cart cart) { this.cart = cart; }
	 */

	/**
	 * @return the cartItemId
	 */
	public Long getCartItemId() {
		return cartItemId;
	}

	/**
	 * @param cartItemId the cartItemId to set
	 */
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * @return the cartItemName
	 */
	public String getCartItemName() {
		return cartItemName;
	}

	/**
	 * @param cartItemName the cartItemName to set
	 */
	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}

	/**
	 * @return the cartItemPrice
	 */
	public float getCartItemPrice() {
		return cartItemPrice;
	}

	/**
	 * @param cartItemPrice the cartItemPrice to set
	 */
	public void setCartItemPrice(float cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartItemName=" + cartItemName + ", cartItemPrice="
				+ cartItemPrice + "]";
	}

}
