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

@WebServlet("/ViewAllProduct")
public class ViewAllProduct extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter();
		ProductDao daoObj= new ProductDaoImpl();
		List<Product> products=null;
		
		String s=request.getParameter("categoryId");
		
		if(s==null){
		products=daoObj.getAllProducts();
		
		
		
		}
		else{
			int catId=Integer.parseInt(s);
			products=daoObj.getAllProductsForCategory(catId);
			
		}
		request.setAttribute("pList",products);
		RequestDispatcher rd= request.getRequestDispatcher("ViewAllProducts.jsp");
		rd.forward(request,response);
		
	}

}
