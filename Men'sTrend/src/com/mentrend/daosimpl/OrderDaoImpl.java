package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.mentrend.daos.OrderDao;
import com.mentrend.models.Order;
import com.mentrend.utility.ConnectionProvider;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean makeOrder(Order order) {
		try {
		Connection conn=ConnectionProvider.getConn();
		PreparedStatement ps=conn.prepareStatement("insert into OrderTab(email,addressid,totalprice) values(?,?,?)");
		ps.setString(1, order.getUserEmail());
		ps.setInt(2,order.getAddressId());
		ps.setDouble(3, order.getTotalPrice());
		
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
