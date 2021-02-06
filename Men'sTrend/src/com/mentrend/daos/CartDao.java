package com.mentrend.daos;

import com.mentrend.models.Cart;

public interface CartDao {
	public boolean addCart(Cart cart);
	public Cart getCartByCustomer(String customerId);
	public boolean deleteCart(int cartId);
}
