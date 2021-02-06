package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mentrend.daos.ProductDao;
import com.mentrend.models.Category;
import com.mentrend.models.Product;
import com.mentrend.utility.ConnectionProvider;

public class ProductDaoImpl implements ProductDao{

	@Override
	public boolean addProduct(Product product) {
		try {
			
			System.out.println("Product Name : "+product.getProductName());
			System.out.println("Product Desc : "+product.getProductDesc());
			System.out.println("Product Price : "+product.getPrice());
			System.out.println("Product Image : "+product.getImage());
			System.out.println("Product Quantity : "+product.getQuantity());
			System.out.println("Product CategoryId : "+product.getCategoryId());
			
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("insert into producttab(productname,productprice,productdesc,productimage,categoryid,productquantity) values(?,?,?,?,?,?)");
			ps.setString(1, product.getProductName());
			ps.setString(3, product.getProductDesc());
			ps.setDouble(2, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(6, product.getQuantity());
			ps.setInt(5, product.getCategoryId());
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}

		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from producttab where PRODUCTID=?");
			ps.setInt(1,productId);
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("update producttab set productname=?,productprice=?, productdesc=?, productimage=?, productquantity=?, categoryId=? where PRODUCTID=?");
			ps.setString(1, product.getProductName());
			ps.setString(3, product.getProductDesc());
			ps.setDouble(2,product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getCategoryId());
			ps.setInt(7, product.getProductId());
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public Product getProductById(int productId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from producttab where PRODUCTID=?");
			ps.setInt(1,productId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(4);
				double price=rs.getDouble(3);
				String image=rs.getString(5);
				int quantity=rs.getInt(6);
				int categoryId=rs.getInt(7);
				
				Product pObj=new Product();
				pObj.setProductId(id);
				pObj.setProductName(name);
				pObj.setProductDesc(desc);
				pObj.setPrice(price);
				pObj.setImage(image);
				pObj.setQuantity(quantity);
				pObj.setCategoryId(categoryId);
				return pObj;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=new ArrayList<>();
		try{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from producttab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Product pObj=new Product();
				pObj.setProductId(rs.getInt(1));
				pObj.setProductName(rs.getString(2));
				pObj.setProductDesc(rs.getString(4));
				pObj.setPrice(rs.getDouble(3));
				pObj.setImage(rs.getString(5));
				pObj.setQuantity(rs.getInt(7));
				pObj.setCategoryId(rs.getInt(6));
				
				list.add(pObj);
				
			}
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProductsForCategory(int categoryId) {
		List<Product> list=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from producttab where categoryid=?");
			ps.setInt(1,categoryId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Product pObj=new Product();
				pObj.setProductId(rs.getInt(1));
				pObj.setProductName(rs.getString(2));
				pObj.setProductDesc(rs.getString(4));
				pObj.setPrice(rs.getDouble(3));
				pObj.setImage(rs.getString(5));
				pObj.setQuantity(rs.getInt(7));
				pObj.setCategoryId(rs.getInt(6));
				
				list.add(pObj);
				
			}
			System.out.println("Product List : "+list);
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> searchProducts(String search) {
		List<Product> Products=new ArrayList<>();
		try{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from producttab where UPPER(productname)LIKE UPPER(?)");
			ps.setString(1,"%"+search+"%");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(4);
				double price=rs.getDouble(3);
				String image=rs.getString(5);
				int quantity=rs.getInt(7);
				int categoryId=rs.getInt(6);
				
				Product pObj=new Product();
				pObj.setProductId(id);
				pObj.setProductName(name);
				pObj.setProductDesc(desc);
				pObj.setPrice(price);
				pObj.setImage(image);
				pObj.setQuantity(quantity);
				pObj.setCategoryId(categoryId);
				Products.add(pObj);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Products;
	}
}