package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mentrend.daos.CartDao;
import com.mentrend.models.Cart;
import com.mentrend.utility.ConnectionProvider;

public class CartDaoImpl implements CartDao {

	@Override
	public boolean addCart(Cart cart) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("insert into Carttab(CustomerID) values(?)");
			ps.setString(1, cart.getUser().getEmail());
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
	public Cart getCartByCustomer(String customerId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from Carttab where customerId=?");
			ps.setString(1, customerId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Cart c=new Cart();
				c.setCartId(rs.getInt(1));
				
				String userId=rs.getString(2);
				c.setUser(new UserDaoImpl().getUser(userId));
				return c;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCart(int cartId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from carttab where cartid=?");
			ps.setInt(1, cartId);
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
