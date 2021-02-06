package com.mentrend.daos;

import com.mentrend.models.User;

public interface UserDao {
	public User validateUser(String email,String pass);
	public boolean registerUser(User userObj);
	public User getUser(String email);
	public boolean updateUser(User userObj);
	public boolean changePassword(String email,String newpassword);
}
