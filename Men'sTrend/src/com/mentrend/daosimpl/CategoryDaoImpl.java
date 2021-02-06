package com.mentrend.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mentrend.daos.CategoryDao;
import com.mentrend.models.Category;
import com.mentrend.utility.ConnectionProvider;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category categoryObj) {
		try {
		Connection conn=ConnectionProvider.getConn();
		PreparedStatement ps=conn.prepareStatement
				("insert into categoryTab (categoryName,categoryDesc) values(?,?)");
		ps.setString(1,categoryObj.getCategoryName());
		ps.setString(2,categoryObj.getCategoryDesc());
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
	public boolean deleteCategory(int catId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from CategoryTab where categoryId=?");
			ps.setInt(1,catId);
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateCategory(Category categoryObj) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("update categorytab set categoryname=? , categorydesc=? where categoryId=?");
			ps.setString(1,categoryObj.getCategoryName());
			ps.setString(2,categoryObj.getCategoryDesc());
			ps.setInt(3,categoryObj.getCategoryId());
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public Category getCategoryById(int catId) {
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from CategoryTab where categoryId=?");
			ps.setInt(1,catId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(3);
				
				Category cObj=new Category();
				cObj.setCategoryId(id);
				cObj.setCategoryName(name);
				cObj.setCategoryDesc(desc);
				return cObj;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from CategoryTab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(3);
				
				Category cObj=new Category();
				cObj.setCategoryId(id);
				cObj.setCategoryName(name);
				cObj.setCategoryDesc(desc);
				
				categories.add(cObj);
				
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return categories;
	}

}
