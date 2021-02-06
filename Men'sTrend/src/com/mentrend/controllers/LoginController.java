package com.mentrend.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mentrend.daos.LoginDao;
import com.mentrend.daos.UserDao;
import com.mentrend.daosimpl.LoginDaoImpl;
import com.mentrend.daosimpl.UserDaoImpl;
import com.mentrend.models.Login;
import com.mentrend.models.User;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("email");
		String s2=request.getParameter("pwd");
		
		LoginDao loginDaoObj=new LoginDaoImpl();
		Login obj=loginDaoObj.validate(s1,s2);
		
		if(obj==null) {
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg","Email or Password is incorrect");
			rd.forward(request, response);
		}
		else {
			String role=obj.getRole();
			
			UserDao obj1=new UserDaoImpl();
			User obj2=obj1.getUser(s1);
			
			HttpSession session1=request.getSession();
			session1.setAttribute("user",role);	
			 
				HttpSession session=request.getSession();
				session.setAttribute("user1",obj2);		 
			
			
			if(role.equals("Admin")) {
				RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
				rd.forward(request, response);
			}
			else  if(role.equals("Customer"))
			{
				
			 RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
				rd.forward(request, response);
				 
			}
		}
	}

}
