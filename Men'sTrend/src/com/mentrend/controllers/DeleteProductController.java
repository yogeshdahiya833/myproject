package com.mentrend.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentrend.daos.ProductDao;
import com.mentrend.daosimpl.ProductDaoImpl;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("productId"));
		
		ProductDao proDao=new ProductDaoImpl();
		boolean r=proDao.deleteProduct(id);
		if(r==true){
			request.setAttribute("msg","Product Deleted Succesfully");
		}
		else {
			request.setAttribute("msg","Problem in Deleting Product. Try again");
		}
		
		request.setAttribute("pList",proDao.getAllProducts());
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllProducts.jsp");
		rd.forward(request, response);
		
		}

	}
