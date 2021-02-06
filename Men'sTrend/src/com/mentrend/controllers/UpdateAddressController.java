package com.mentrend.controllers;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentrend.daos.AddressDao;
import com.mentrend.daosimpl.AddressDaoImpl;
import com.mentrend.models.Address;
@WebServlet("/UpdateAddress")
public class UpdateAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("addressId"));
		
		AddressDao aDao=new AddressDaoImpl();
		Address address= aDao.getAddressById(id);
		
		
		
		request.setAttribute("aObj",address);
		RequestDispatcher rd=request.getRequestDispatcher("UpdateAddressForm.jsp");
		rd.forward(request, response);
		
		}
	}


