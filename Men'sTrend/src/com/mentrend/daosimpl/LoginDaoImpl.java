package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mentrend.daos.LoginDao;
import com.mentrend.models.Login;
import com.mentrend.utility.ConnectionProvider;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Login validate(String emailId, String pass) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from LoginTab where loginid=? and password=?");
			ps.setString(1,emailId);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String s1=rs.getString(1);
				String s2=rs.getString(2);
				String s3=rs.getString(3);
				
				Login obj=new Login();
				obj.setEmailId(s1);
				obj.setPassword(s2);
				obj.setRole(s3);
				return obj;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
