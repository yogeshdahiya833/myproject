package com.mentrend.daos;

import com.mentrend.models.Order;

public interface OrderDao {
	public boolean makeOrder(Order order);
}
