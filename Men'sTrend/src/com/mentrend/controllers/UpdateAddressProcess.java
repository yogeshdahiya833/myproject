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

@WebServlet("/UpdateAddressProcess")
public class UpdateAddressProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession();
         Object obj=session.getAttribute("user");
         User uObj=(User)obj;
      	String em=uObj.getEmail();
		int id=Integer.parseInt(request.getParameter("addressId"));
		String a1=request.getParameter("addrLine1");
		String a2=request.getParameter("addrLine2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		Integer pin=Integer.parseInt(request.getParameter("pin"));
		
		System.out.println("");
		
		
		Address aObj=new Address();
		aObj.setAddressId(id);
		aObj.setAddressLine1(a1);
		aObj.setAddressLine2(a2);
		aObj.setCity(city);
		aObj.setState(state);
		aObj.setPinCode(pin);
		aObj.setUserEmail(em);
	
		
		AddressDao daoObj=new AddressDaoImpl();
		boolean r=daoObj.updateAddress(aObj);
		if(r){
			List<Address> addressesList=daoObj.getAddress(em);
			
			request.setAttribute("aList",addressesList);

			request.setAttribute("msg","Address Updated Succesfully");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAddress.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg1","Fail to Update Address..Address already exist.");
			RequestDispatcher rd=request.getRequestDispatcher("UpdateAddressForm.jsp");
			rd.forward(request, response);
		}
				
		
	}
	}


