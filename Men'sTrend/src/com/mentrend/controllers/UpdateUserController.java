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
import javax.servlet.http.HttpSession;

import com.mentrend.daos.UserDao;
import com.mentrend.daosimpl.UserDaoImpl;
import com.mentrend.models.User;

@WebServlet("/updateUser")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("I  m update User");
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
    	String s1=request.getParameter("email");
    	String s2=request.getParameter("fName");
    	String s3=request.getParameter("lName");
    	String s4=request.getParameter("gender");
    	String s5=request.getParameter("dob");
    	
    	//Converting String into java.util.Date
    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	Date dob=null;
		try {
			dob = sdf.parse(s5);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	User userObj=new User();
    	userObj.setEmail(s1);
    	userObj.setFirstName(s2);
    	userObj.setLastName(s3);
    	userObj.setGender(s4);
    	userObj.setDateOfBirth(dob);
    	
    	UserDao dao=new UserDaoImpl();
    	boolean r=dao.updateUser(userObj);
    	
    	
    	
    	if(r){
    		System.out.println("I m in if");
    		User newObj=dao.getUser(userObj.getEmail());
    		System.out.println("New Obj : "+newObj);
    		HttpSession session=request.getSession();
    		request.setAttribute("msg", "User updated Succesfully");
    		session.setAttribute("user1",newObj);
    		RequestDispatcher rd=request.getRequestDispatcher("ViewProfile.jsp");
    		rd.forward(request, response);
    	}
    	else {
    		
    		System.out.println("I m in else");
    		request.setAttribute("msg", "Problem in Updation");
    		RequestDispatcher rd=request.getRequestDispatcher("UpdateProfile.jsp");
    		rd.forward(request, response);
    				
    	}
	}

}