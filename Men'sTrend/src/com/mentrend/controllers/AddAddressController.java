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
import com.mentrend.daos.CategoryDao;
import com.mentrend.daosimpl.AddressDaoImpl;
import com.mentrend.daosimpl.CategoryDaoImpl;
import com.mentrend.models.Address;
import com.mentrend.models.Category;
import com.mentrend.models.User;


@WebServlet("/addAddress")
public class AddAddressController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");

		
		String addrLine1=request.getParameter("addrLine1");
		String addrLine2=request.getParameter("addrLine2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		
		
		Address addr=new Address();
		addr.setAddressLine1(addrLine1);
		addr.setAddressLine2(addrLine2);
		addr.setCity(city);
		addr.setState(state);
		addr.setPinCode(pincode);
		addr.setUserEmail(user.getEmail());
		
		AddressDao addrDao=new AddressDaoImpl();
		
		boolean r=addrDao.addAddress(addr);
		if(r){
			
			List<Address> addressList=addrDao.getAddress(user.getEmail());
			
			request.setAttribute("aList",addressList);
			request.setAttribute("msg","Address Added Succesfully");
			RequestDispatcher rd=request.getRequestDispatcher("AddressForm.jsp");
			rd.forward(request, response);
		}
		else {
			
		}
				
		
	}

}
