package com.mentrend.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

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

/**
 * Servlet implementation class UpdateProductProcess
 */
@WebServlet("/UpdateProductProcess")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateProductProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("productId"));
		String name=request.getParameter("productName");
		String desc=request.getParameter("productDesc");
		double price=Double.parseDouble(request.getParameter("price"));
		Part filePart=request.getPart("image");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int catId=Integer.parseInt(request.getParameter("product_categorie"));
		
		
		Product p=new Product();
		p.setProductId(id);
		p.setProductName(name);
		p.setProductDesc(desc);
		p.setPrice(price);
		p.setImage(filePart.getSubmittedFileName());
		p.setQuantity(quantity);
		p.setCategoryId(catId);
		
		//image
		String fileName=filePart.getSubmittedFileName();
		System.out.println("File Name : "+fileName);
		
		HttpSession session=request.getSession();
		String serverLocation=session.getServletContext().getRealPath("/");
		System.out.println(serverLocation);
		
		String filePath=serverLocation+"\\images";
		System.out.println("filePath : "+filePath);
		
		File fileObj=new File(filePath);
		if(!fileObj.exists()){
			fileObj.createNewFile();
		}
		
		InputStream is=filePart.getInputStream();
		BufferedInputStream bis=new BufferedInputStream(is);
		
		FileOutputStream fos=new FileOutputStream(filePath+"/"+fileName+".jpg");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		int ch;
		while((ch=bis.read())!=-1){
			bos.write(ch);
		}
		
		bos.close();
		fos.close();
		
				ProductDao daoObj=new ProductDaoImpl();
		boolean r=daoObj.updateProduct(p);
		
		List<Product> productsList=daoObj.getAllProducts();
		if(r){
					
			request.setAttribute("pList", productsList);
			request.setAttribute("msg","Products Updated Succesfully");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllProducts.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("pList", productsList);
			request.setAttribute("msg","Problem in Product Updations");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllProducts.jsp");
			rd.forward(request, response);
			
		}	
		
	}

}
