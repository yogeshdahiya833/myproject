package com.mentrend.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mentrend.daos.ContactDao;
import com.mentrend.daosimpl.ContactDaoImpl;
import com.mentrend.models.Contact;



@WebServlet("/ViewContact")
public class ViewContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
			

			//PrintWriter out=response.getWriter();
			
			ContactDao daoObj=new ContactDaoImpl();
			List<Contact> contactList=daoObj.getAllContacts();
			
			request.setAttribute("cList",contactList);
			RequestDispatcher rd=request.getRequestDispatcher("ViewContacts.jsp");
			rd.forward(request, response);
	}

}
