package com.mentrend.daos;

import com.mentrend.models.Login;

public interface LoginDao {
	public Login validate(String emailId,String pass);

}
