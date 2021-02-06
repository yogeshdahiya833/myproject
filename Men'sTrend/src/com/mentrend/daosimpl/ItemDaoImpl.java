package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mentrend.daos.ItemDao;
import com.mentrend.models.Cart;
import com.mentrend.models.Item;
import com.mentrend.utility.ConnectionProvider;

public class ItemDaoImpl implements ItemDao {

	@Override
	public boolean addItem(Item item) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("insert into ItemTable(CustomerID,Price,Quantity,ProductId,CartId) values(?,?,?,?,?)");
			ps.setString(1, item.getCustomerId());
			ps.setDouble(2, item.getPrice());
			ps.setInt(3, item.getQuantity());
			ps.setInt(4, item.getProduct().getProductId());
			ps.setInt(5, item.getCart().getCartId());
			
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(int id) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from Itemtable  where itemid=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}


	@Override
	public Item getItemByProductIdAndCustomerId(int productId, String customerId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from itemtable where productid=? and CustomerId=?");
			ps.setInt(1, productId);
			ps.setString(2, customerId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Item item=new Item();
				item.setCart(new CartDaoImpl().getCartByCustomer(customerId));
				item.setCustomerId(customerId);
				item.setItemId(rs.getInt(1));
				item.setPrice(rs.getDouble(3));
				item.setQuantity(rs.getInt(4));
				item.setProduct(new ProductDaoImpl().getProductById(productId));
				return item;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> getItemsListByCart(int cartId) {
		List<Item> items=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from itemtable where cartid=?");
			ps.setInt(1,cartId);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Item item=new Item();
				item.setItemId(rs.getInt(1));
				item.setPrice(rs.getDouble(3));
				item.setCustomerId(rs.getString(2));
				item.setQuantity(rs.getInt(4));
				item.setProduct(new ProductDaoImpl().getProductById(rs.getInt(5)));
				item.setCart(new CartDaoImpl().getCartByCustomer(rs.getString(6)));
				
				items.add(item);
				
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		return items;
	}

	@Override
	public boolean increaseQuantity(int id) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("Update Itemtable set quantity=quantity+1 where itemid=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}



	@Override
	public boolean decreaseQuantity(int id) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("Update Itemtable set quantity=quantity-1 where itemid=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public Item getItemById(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByCartId(int cartId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from  Itemtable where cartid=?");
			ps.setInt(1,cartId);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}

}
