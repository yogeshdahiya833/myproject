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

import com.mentrend.daos.ItemDao;
import com.mentrend.daosimpl.ItemDaoImpl;
import com.mentrend.models.Category;


@WebServlet("/removeItem")
public class RemoveItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int id=Integer.parseInt(request.getParameter("itemId"));
		
		ItemDao itemDaoObj=new ItemDaoImpl();
		itemDaoObj.deleteItem(id);
		
		RequestDispatcher rd=request.getRequestDispatcher("viewCart");
			rd.forward(request, response);
		
	}

}                     