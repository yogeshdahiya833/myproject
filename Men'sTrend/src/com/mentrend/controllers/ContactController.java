package com.mentrend.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentrend.daos.ContactDao;
import com.mentrend.daos.UserDao;
import com.mentrend.daosimpl.ContactDaoImpl;
import com.mentrend.daosimpl.UserDaoImpl;
import com.mentrend.models.Contact;
import com.mentrend.models.User;


@WebServlet("/contactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
    	String s1=request.getParameter("fName");
    	String s2=request.getParameter("lName");
    	String s3=request.getParameter("email");
    	String s4=request.getParameter("Message");
    	
    	Contact ctObj=new Contact();
    	
    	ctObj.setFirstName(s1);
    	ctObj.setLastName(s2);
    	ctObj.setEmail(s3);
    	ctObj.setMessage(s4);
   
    	ContactDao dao=new ContactDaoImpl();
    	boolean r=dao.addContact(ctObj);
    	if(r){
    		
    		request.setAttribute("msg","Thanks for Contact Us!");
    		RequestDispatcher rd=request.getRequestDispatcher("Contact_Us.jsp");
    		rd.include(request, response);
    	}
    	
			}

}
