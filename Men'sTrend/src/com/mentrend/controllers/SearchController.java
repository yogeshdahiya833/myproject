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

import com.mentrend.daos.ProductDao;
import com.mentrend.daosimpl.ProductDaoImpl;
import com.mentrend.models.Product;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String search=request.getParameter("Search");
		
		ProductDao daoObj=new ProductDaoImpl();
		List<Product> productsList=daoObj.searchProducts(search);
		
		{
		request.setAttribute("pList",productsList);
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllProducts.jsp");
		rd.forward(request, response);}



	}
	

	}



