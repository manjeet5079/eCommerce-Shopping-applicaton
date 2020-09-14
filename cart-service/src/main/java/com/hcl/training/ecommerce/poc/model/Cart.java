package com.hcl.training.ecommerce.poc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Manjeet Kumar
 *
 *         Sep 4, 2020
 *
 */

@Entity
@Table(name = "CART")
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue//(strategy = GenerationType.AUTO)
	@Column(name = "CART_ID")
	private Long cartId;

	//@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy="cart")
	private List<CartItem> cartItems;

	@Column(name = "CART_TOTAL")
	private float cartTotal;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cartId
	 * @param cartItems
	 * @param cartTotal
	 */
	public Cart(Long cartId, List<CartItem> cartItems, float cartTotal) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.cartTotal = cartTotal;
	}

	/**
	 * @return the cartId
	 */
	public Long getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartItems
	 */

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * @return the cartTotal
	 */
	public float getCartTotal() {
		return cartTotal;
	}

	/**
	 * @param cartTotal the cartTotal to set
	 */
	public void setCartTotal(float cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", cartTotal=" + cartTotal + "]";
	}

}
