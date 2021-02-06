package com.mentrend.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentrend.daos.CategoryDao;
import com.mentrend.daos.ProductDao;
import com.mentrend.daosimpl.CategoryDaoImpl;
import com.mentrend.daosimpl.ProductDaoImpl;
import com.mentrend.models.Product;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("productId"));
		
		ProductDao pDao=new ProductDaoImpl();
		Product product=pDao.getProductById(id);

		System.out.println("product obj = "+product);
		
		
		CategoryDao category=new CategoryDaoImpl();
		
		request.setAttribute("pObj",product);
		request.setAttribute("cList",category.getAllCategories());
		
		RequestDispatcher rd=request.getRequestDispatcher("UpdateProductForm.jsp");
		rd.forward(request, response);

	}

}
