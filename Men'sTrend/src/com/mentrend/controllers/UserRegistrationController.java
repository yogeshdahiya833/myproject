package com.mentrend.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentrend.daos.UserDao;
import com.mentrend.daosimpl.UserDaoImpl;
import com.mentrend.models.User;

@WebServlet("/registerUser")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
    	String s1=request.getParameter("email");
    	String s2=request.getParameter("pwd");
    	String s3=request.getParameter("fName");
    	String s4=request.getParameter("lName");
    	String s5=request.getParameter("gender");
    	String s6=request.getParameter("dob");
    	String s7=request.getParameter("role");
    	//Converting String into java.util.Date
    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	Date dob=null;
		try {
			dob = sdf.parse(s6);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	User userObj=new User();
    	userObj.setEmail(s1);
    	userObj.setPassword(s2);
    	userObj.setFirstName(s3);
    	userObj.setLastName(s4);
    	userObj.setGender(s5);
    	userObj.setDateOfBirth(dob);
    	userObj.setRole(s7);
    	
    	UserDao dao=new UserDaoImpl();
    	boolean r=dao.registerUser(userObj);
    	if(r){
    		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
    		rd.forward(request,response);
    	}
    	else {
    		RequestDispatcher rd=request.getRequestDispatcher("SignUp.jsp");
    		rd.forward(request, response);
    				
    	}
    	
	}

}
