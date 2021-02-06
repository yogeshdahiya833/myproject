package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mentrend.daos.ContactDao;
import com.mentrend.models.Contact;
import com.mentrend.models.User;
import com.mentrend.utility.ConnectionProvider;

public class ContactDaoImpl  implements ContactDao{

	@Override
	public boolean addContact(Contact contObj) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("insert into ContactTab values(?,?,?,?)");
			
			ps.setString(1,contObj.getFirstName());
			ps.setString(2,contObj.getLastName());
			ps.setString(3,contObj.getEmail());
			ps.setString(4,contObj.getMessage());
			
			System.out.println(contObj.getFirstName());
			System.out.println(contObj.getLastName());
			System.out.println(contObj.getEmail());
			System.out.println(contObj.getMessage());
			
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
	public Contact getUser(String email) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from ContactTab where email=?");
			ps.setString(3,email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			  Contact con=new Contact();
			  
			  con.setFirstName(rs.getString(1));
			  con.setLastName(rs.getString(2));
			  con.setEmail(rs.getString(3));
			  con.setMessage(rs.getString(4));
			  return con;		  
			  
			}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
		
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from ContactTab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				String firstName=rs.getString(1);
				String lastName=rs.getString(2);
				String email=rs.getString(3);
				String message=rs.getString(4);
				
				Contact sObj=new Contact();
				
				sObj.setFirstName(firstName);
				sObj.setLastName(lastName);
				sObj.setEmail(email);
				sObj.setMessage(message);
				contacts.add(sObj);
				
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return contacts;
	}

	@Override
	public Contact getContactById(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContact(String email) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from ContactTab where email=?");
			ps.setString(1,email);
			int i=ps.executeUpdate();
			if(i!=0)return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}

	
		

