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
import com.mentrend.daos.ProductDao;
import com.mentrend.daosimpl.CartDaoImpl;
import com.mentrend.daosimpl.ItemDaoImpl;
import com.mentrend.daosimpl.ProductDaoImpl;
import com.mentrend.models.Cart;
import com.mentrend.models.Item;
import com.mentrend.models.Product;
import com.mentrend.models.User;


@WebServlet("/addToCart")
public class AddToCartController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int productId=Integer.parseInt(request.getParameter("Id"));
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		if(user==null){
			request.setAttribute("msg","You need to login first");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else {
			CartDao cartDaoObj=new CartDaoImpl();
		
			String customerEmail=user.getEmail();
			
			Cart cartObj=cartDaoObj.getCartByCustomer(customerEmail);
			if(cartObj==null){
				System.out.println("Cart doesnt exist");
				cartObj=new Cart();
				cartObj.setUser(user);
				
				cartDaoObj.addCart(cartObj);
				System.out.println("Cart created succesfully");
				cartObj=cartDaoObj.getCartByCustomer(customerEmail);
				
			}
			else {
				System.out.println("Cart already exist");
			}
			
			ProductDao productDaoObj=new ProductDaoImpl();
			ItemDao itemDaoObj=new ItemDaoImpl();
			Product pro=productDaoObj.getProductById(productId);
			
			Item itemObj=new Item();
			itemObj.setCart(cartObj);
			itemObj.setCustomerId(customerEmail);
			itemObj.setPrice(pro.getPrice());
			itemObj.setProduct(pro);
			itemObj.setQuantity(1);
			
			
			itemDaoObj.addItem(itemObj);
			System.out.println("Item Added Succesfully");
			
			List<Item> itemList=itemDaoObj.getItemsListByCart(cartObj.getCartId());
			request.setAttribute("cartList",itemList);
			
			HttpSession session1=request.getSession();
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
