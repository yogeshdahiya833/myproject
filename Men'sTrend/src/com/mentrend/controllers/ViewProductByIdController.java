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

/**
 * Servlet implementation class ViewProductByIdController
 */
@WebServlet("/ViewProductByIdController")
public class ViewProductByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("catId"));
		
		ProductDao daoObj=new ProductDaoImpl();
		List<Product> products=daoObj.getAllProductsForCategory(id);
		
		request.setAttribute("pList",products);
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllProducts.jsp");
		rd.forward(request, response);
	}

}
