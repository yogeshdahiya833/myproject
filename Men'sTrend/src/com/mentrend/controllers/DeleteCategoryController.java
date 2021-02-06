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

@WebServlet("/deleteCategory")
public class DeleteCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	int id=Integer.parseInt(request.getParameter("catId"));
	
	CategoryDao catDao=new CategoryDaoImpl();
	boolean r=catDao.deleteCategory(id);
	if(r==true){
		request.setAttribute("msg","Category Deleted Succesfully");
	}
	else {
		request.setAttribute("msg","Problem in Deleting Category . Try again");
	}
	request.setAttribute("cList",catDao.getAllCategories());
	RequestDispatcher rd=request.getRequestDispatcher("ViewCategories.jsp");
	rd.forward(request, response);
	
	}

}
