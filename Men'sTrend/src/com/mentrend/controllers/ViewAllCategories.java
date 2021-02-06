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

import com.mentrend.daos.CategoryDao;
import com.mentrend.daosimpl.CategoryDaoImpl;
import com.mentrend.models.Category;

@WebServlet("/viewAllCategories")
public class ViewAllCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		
		String s=request.getParameter("x");
	
		
		CategoryDao daoObj=new CategoryDaoImpl(); 
		List<Category> categoriesList=daoObj.getAllCategories();
		
		request.setAttribute("cList",categoriesList); 
	
			
		if(s==null){
			RequestDispatcher rd=request.getRequestDispatcher("ViewCategories.jsp"); 
			rd.forward(request, response);  
		
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("AddProduct.jsp");
			rd.forward(request, response);
		
		}
		
		
				
	}

}
