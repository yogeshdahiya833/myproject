package com.mentrend.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mentrend.daos.CartDao;
import com.mentrend.daos.ItemDao;
import com.mentrend.daos.OrderDao;
import com.mentrend.daosimpl.CartDaoImpl;
import com.mentrend.daosimpl.ItemDaoImpl;
import com.mentrend.daosimpl.OrderDaoImpl;
import com.mentrend.models.Address;
import com.mentrend.models.Order;
import com.mentrend.models.User;


@WebServlet("/processPayment")
public class ProcessPaymentController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");

		Address addrObj=(Address)session.getAttribute("addr");
		
		String userEmail=user.getEmail();
		
		double total=(Double)session.getAttribute("total");
		
		Order order=new Order();
		order.setAddressId(addrObj.getAddressId());
		order.setTotalPrice(total);
		order.setUserEmail(user.getEmail());
		
		OrderDao orderDao=new OrderDaoImpl();
		ItemDao itemDao=new ItemDaoImpl();
		
		if(orderDao.makeOrder(order)){
			CartDao cart=new CartDaoImpl();
			
			int cartId=cart.getCartByCustomer(user.getEmail()).getCartId();
			
			itemDao.deleteByCartId(cartId);
			cart.deleteCart(cartId);
			RequestDispatcher rd=request.getRequestDispatcher("OrderPlaced.jsp");
			request.setAttribute("itemsList","");
			rd.forward(request, response);
		
		}
		
		
				
	}

}
