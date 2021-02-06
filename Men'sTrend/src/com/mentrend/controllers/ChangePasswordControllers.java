package com.mentrend.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mentrend.daos.UserDao;
import com.mentrend.daosimpl.UserDaoImpl;
import com.mentrend.models.User;

/**
 * Servlet implementation class ChangePasswordControllers
 */
@WebServlet("/ChangePasswordControllers")
public class ChangePasswordControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User obj=(User)session.getAttribute("user");
		
		String s1=request.getParameter("npwd");
		String s2=request.getParameter("cpwd");
		if(s1.equals(s2)){
			UserDao obj1=new UserDaoImpl();
			boolean obj2= obj1.changePassword(obj.getEmail(),s1);
			if(obj2==true){
				request.setAttribute("msg","Password Changed Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
				rd.forward(request,response);
			}
			else
				
			{
			request.setAttribute("msg","Problem in changing password");
			RequestDispatcher rd= request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request,response);
			}
		}
		
		
	}

}
