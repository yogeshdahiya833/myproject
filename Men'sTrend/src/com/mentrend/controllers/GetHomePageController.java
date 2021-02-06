package com.mentrend.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentrend.daos.CategoryDao;
import com.mentrend.daosimpl.CategoryDaoImpl;
import com.mentrend.models.Category;

@WebServlet("/getHomePage")
public class GetHomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		
		
		
		CategoryDao daoObj=new CategoryDaoImpl(); 
		List<Category> categoriesList=daoObj.getAllCategories();
		
		ServletContext context=getServletContext();
		context.setAttribute("cList",categoriesList); 
	
		
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		
		
				
	}

}
