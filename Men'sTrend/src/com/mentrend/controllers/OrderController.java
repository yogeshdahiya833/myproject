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
import com.mentrend.daos.CartDao;
import com.mentrend.daos.ItemDao;
import com.mentrend.daosimpl.AddressDaoImpl;
import com.mentrend.daosimpl.CartDaoImpl;
import com.mentrend.daosimpl.ItemDaoImpl;
import com.mentrend.models.Address;
import com.mentrend.models.Cart;
import com.mentrend.models.Item;
import com.mentrend.models.User;


@WebServlet("/orderController")
public class OrderController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String email=user.getEmail();
		
		int addressId=Integer.parseInt(request.getParameter("addressId"));
		
		AddressDao addrDao=new AddressDaoImpl();
		CartDao cartDao=new CartDaoImpl();
		ItemDao itemDao=new ItemDaoImpl();
		
		Address addr=addrDao.getAddressById(addressId);
		Cart cartObj=cartDao.getCartByCustomer(email);
		List<Item> itemsList=itemDao.getItemsListByCart(cartObj.getCartId());
		
		
			request.setAttribute("cart",cartObj);
			session.setAttribute("addr",addr);
			request.setAttribute("itemsList",itemsList);
			
			RequestDispatcher rd=request.getRequestDispatcher("OrderPlaced.jsp");
			rd.forward(request, response);
		
				
		
	}

}
