package com.mentrend.daosimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.mentrend.daos.UserDao;
import com.mentrend.models.User;
import com.mentrend.utility.ConnectionProvider;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean registerUser(User userObj) {
		try {
		Connection conn=ConnectionProvider.getConn();
		PreparedStatement ps=conn.prepareStatement("insert into usertab values(?,?,?,?,?,?,?)");
		ps.setString(1,userObj.getEmail());
		ps.setString(2,userObj.getPassword());
		ps.setString(3,userObj.getFirstName());
		ps.setString(4,userObj.getLastName());
		ps.setString(5,userObj.getGender());
		ps.setString(7,"user");
		
		/*Converting java.util.Date into java.sql.Date*/
		Date dateOfBirth=userObj.getDateOfBirth();
		long l=dateOfBirth.getTime();
		java.sql.Date dob=new java.sql.Date(l);
		ps.setDate(6, dob);
		
		int i=ps.executeUpdate();
		if(i!=0){
			return true;
		}
		else {
			return false;
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(String email) {
		try {
			Connection conn=ConnectionProvider.getConn();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean updateUser(User userObj) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("Update usertab set firstName=?,lastName=?,gender=?,dateOfbirth=? where email=?");
			ps.setString(5,userObj.getEmail());
			ps.setString(1,userObj.getFirstName());
			ps.setString(2,userObj.getLastName());
			ps.setString(3,userObj.getGender());
			
			/*Converting java.util.Date into java.sql.Date*/
			Date dateOfBirth=userObj.getDateOfBirth();
			long l=dateOfBirth.getTime();
			java.sql.Date dob=new java.sql.Date(l);
			ps.setDate(4, dob);
			
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			else {
				return false;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean changePassword(String email, String newpassword) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps =conn.prepareStatement("Update usertab set Password=? where Email=?");
			ps.setString(1,newpassword);
			ps.setString(2,email);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				return true;
			}
		}
		catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public User validateUser(String email, String pass) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from usertab where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String em=rs.getString(1);
				String pa=rs.getString(2);
				String fname=rs.getString(3);
				String lname=rs.getString(4);
				String gen=rs.getString(5);
				//Date dob=rs.getDate(6);
				
				User obj=new User();
				obj.setEmail(em);
				obj.setPassword(pa);
				obj.setFirstName(fname);
				obj.setLastName(lname);
				obj.setGender(gen);
				//obj.setDateOfBirth(dob);
				obj.setRole(rs.getString(7));
				
				return obj;
			}
			else {
				return null;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		return null;
	}

}
