package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mentrend.daos.AddressDao;
import com.mentrend.models.Address;
import com.mentrend.utility.ConnectionProvider;

public class AddressDaoImpl implements AddressDao{

	@Override
	public boolean addAddress(Address obj) {
		try {
		Connection conn=ConnectionProvider.getConn();
		PreparedStatement ps=conn.prepareStatement("insert into AddressTab(addrLine1,addrLine2,city,state,pin,email) values(?,?,?,?,?,?)");
		ps.setString(1, obj.getAddressLine1());
		ps.setString(2, obj.getAddressLine2());
		ps.setString(3, obj.getCity());
		ps.setString(4, obj.getState());
		ps.setInt(5, obj.getPinCode());
		ps.setString(6, obj.getUserEmail());
		
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
	public boolean deleteAddress(int addressId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from AddressTab where addressId=?");
			ps.setInt(1, addressId);
			
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
	public boolean updateAddress(Address obj) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("Update AddressTab set addrLine1=?,addrLine2=?,city=?,state=?,pin=?,email=? where addressId=?");
			ps.setString(1, obj.getAddressLine1());
			ps.setString(2, obj.getAddressLine2());
			ps.setString(3, obj.getCity());
			ps.setString(4, obj.getState());
			ps.setInt(5, obj.getPinCode());
			ps.setString(6, obj.getUserEmail());
			ps.setInt(7, obj.getAddressId());
			
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
	public List<Address> getAddress(String email) {
		
		List<Address> list=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from AddressTab where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String addrLine1=rs.getString(2);
				String addrLine2=rs.getString(3);
				String city=rs.getString(4);
				String state=rs.getString(5);
				int pin=rs.getInt(6);
				email=rs.getString(7);
				
				Address addr=new Address();
				addr.setAddressId(id);
				addr.setAddressLine1(addrLine1);
				addr.setAddressLine2(addrLine2);
				addr.setCity(city);
				addr.setState(state);
				addr.setPinCode(pin);
				addr.setUserEmail(email);
				
				list.add(addr);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return list;
	}

	@Override
	public Address getAddressById(int addressId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from AddressTab where addressId=?");
			ps.setInt(1, addressId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String addrLine1=rs.getString(2);
				String addrLine2=rs.getString(3);
				String city=rs.getString(4);
				String state=rs.getString(5);
				int pin=rs.getInt(6);
				String email=rs.getString(7);
				
				Address addr=new Address();
				addr.setAddressId(id);
				addr.setAddressLine1(addrLine1);
				addr.setAddressLine2(addrLine2);
				addr.setCity(city);
				addr.setState(state);
				addr.setPinCode(pin);
				addr.setUserEmail(email);
				
				return addr;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

}
