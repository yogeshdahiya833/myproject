package com.mentrend.daos;

import java.util.List;

import com.mentrend.models.Item;

public interface ItemDao {
	
	public boolean addItem(Item item);
	public boolean updateItem(Item item);
	public boolean deleteItem(int itemId);
	public Item getItemByProductIdAndCustomerId(int productId,String customerId);
	public List<Item> getItemsListByCart(int cartId);
	public boolean increaseQuantity(int itemId);
	public boolean decreaseQuantity(int itemId);
	public Item getItemById(int itemId);
	public boolean deleteByCartId(int cartId);
}
