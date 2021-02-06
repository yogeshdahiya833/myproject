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
import com.mentrend.daosimpl.CategoryDaoImpl;
import com.mentrend.models.Category;

@WebServlet("/updateCategory")
public class UpdateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("catId"));
		
		CategoryDao catDao=new CategoryDaoImpl();
		Category cat=catDao.getCategoryById(id);
		
		
		
		request.setAttribute("categoryObj",cat);
		RequestDispatcher rd=request.getRequestDispatcher("UpdateCategoryForm.jsp");
		rd.forward(request, response);
	}

}
