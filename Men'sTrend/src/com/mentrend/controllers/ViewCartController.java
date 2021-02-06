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

import com.mentrend.daos.CartDao;
import com.mentrend.daos.ItemDao;

import com.mentrend.daosimpl.CartDaoImpl;
import com.mentrend.daosimpl.ItemDaoImpl;

import com.mentrend.models.Cart;
import com.mentrend.models.User;
import com.mentrend.models.Item;

@WebServlet("/viewCart")
public class ViewCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		HttpSession session1=request.getSession();
		Object obj=session1.getAttribute("user");
		
		User useObj=(User)obj;
		String userId=useObj.getEmail();
		
		CartDao cartObj=new CartDaoImpl();
		ItemDao itemDao=new ItemDaoImpl();
	
		Cart cart=cartObj.getCartByCustomer(userId);
		
		
		if(cart==null){
			RequestDispatcher rd=request.getRequestDispatcher("ViewCart.jsp");
			rd.forward(request, response);
	
		}
		else {
		
		 int cartId=cart.getCartId();
		List<Item> itemList=itemDao.getItemsListByCart(cartId);
		for(Item itemObj:itemList){
			System.out.println(itemObj);
		}
		
		request.setAttribute("cartList",itemList);
		
		
		double total=0;
		for(Item item:itemList){
			total=(item.getPrice()*item.getQuantity())+total;
		}
		
		session1.setAttribute("total",total);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewCart.jsp");
		rd.forward(request, response);

		}

	}

	}


