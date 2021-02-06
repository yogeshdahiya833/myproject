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

import com.mentrend.daosimpl.ContactDaoImpl;

@WebServlet("/DeleteContactController")
public class DeleteContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   
    	   response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		
   		String email=request.getParameter("email");
   		
   		ContactDao conDao=new ContactDaoImpl();
   		boolean r= conDao.deleteContact(email);
   		
   		if(r==true){
   			request.setAttribute("msg","Contact Deleted Succesfully");
   		}
   		else {
   			request.setAttribute("msg","Problem in Deleting Contact . Try again");
   		}
   		request.setAttribute("sList",conDao.getAllContacts());
   		RequestDispatcher rd=request.getRequestDispatcher("ViewContacts.jsp");
   		rd.forward(request, response);
		
	}


}
