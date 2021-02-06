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
import javax.servlet.http.HttpSession;

import com.mentrend.daos.AddressDao;
import com.mentrend.daosimpl.AddressDaoImpl;
import com.mentrend.models.Address;
import com.mentrend.models.User;


@WebServlet("/fetchAddresses")
public class FetchAddresses extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		String customerEmail=user.getEmail();
					
		AddressDao addressDao=new AddressDaoImpl();
		List<Address> addresses=addressDao.getAddress(customerEmail);
		
		if(addresses.isEmpty()){
			
			request.setAttribute("msg","No existing address found. Please add the address for delivery");
			RequestDispatcher rd=request.getRequestDispatcher("AddressForm.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("aList",addresses);
			request.setAttribute("msg","Select the Address For Delivery");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAddress.jsp");
			rd.forward(request, response);
		}
		
	}
}
