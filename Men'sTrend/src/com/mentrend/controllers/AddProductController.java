package com.mentrend.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mentrend.daos.ProductDao;
import com.mentrend.daosimpl.ProductDaoImpl;
import com.mentrend.models.Product;


@WebServlet("/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int catId=Integer.parseInt(request.getParameter("product_categorie"));
		System.out.println("Category Id : "+catId);
		
		String name=request.getParameter("productName");
		
		double price=Double.parseDouble(request.getParameter("price"));
		String desc=request.getParameter("product_description");
		int quantity=Integer.parseInt(request.getParameter("available_quantity"));

		
		
		Part filePart=request.getPart("image");
		
		Product p=new Product();
		p.setProductName(name);
		p.setPrice(price);
		p.setImage(filePart.getSubmittedFileName());
		p.setCategoryId(catId);
		p.setQuantity(quantity);
		p.setProductDesc(desc);
		
		
		
		String fileName=filePart.getSubmittedFileName();
		
		System.out.println("File Name : "+fileName);
		
		System.out.println(name+" "+price+" "+catId);
		
		HttpSession session=request.getSession();
		String serverLocation=session.getServletContext().getRealPath("/");
		System.out.println(serverLocation);
		
		String filePath=serverLocation+"Images";
		System.out.println("filePath : "+filePath);
		
		File fileObj=new File(filePath);
		if(!fileObj.exists()){
			fileObj.createNewFile();
		}
		
		InputStream is=filePart.getInputStream();
		BufferedInputStream bis=new BufferedInputStream(is);
		
		FileOutputStream fos=new FileOutputStream(filePath+"/"+fileName);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		int ch;
		while((ch=bis.read())!=-1){
			bos.write(ch);
		}
		
		bos.close();
		fos.close();
		ProductDao daoObj=new ProductDaoImpl();
		boolean r=daoObj.addProduct(p);
		if(r){
			request.setAttribute("msg", "Product Added Succesfully");
			request.setAttribute("pList", daoObj.getAllProducts());
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllProducts.jsp");
			rd.forward(request, response);
			
		}
		else {
			request.setAttribute("msg", "Problem in Adding Product");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllProducts.jsp");
			rd.forward(request, response);
			
		}
				
		
	}

}
