package com.mentrend.daos;

import java.util.List;

import com.mentrend.models.Category;
import com.mentrend.models.Product;

public interface ProductDao {
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProducts();
	public List<Product> getAllProductsForCategory(int categoryId);
	public List<Product> searchProducts(String search);

}
