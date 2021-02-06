package com.mentrend.models;

import java.util.ArrayList;
import java.util.Collection;

public class Cart {

	private int cartId;
	private User user;
	
	private Collection<Item> items=new ArrayList<>();
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<Item> getItems() {
		return items;
	}
	public void setItems(Collection<Item> items) {
		this.items = items;
	}
	
	
	
	
}
