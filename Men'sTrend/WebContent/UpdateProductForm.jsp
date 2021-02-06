<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
 <%@ page language="java" import="java.sql.*" %>
 <%@ page language="java" import="com.mentrend.utility.ConnectionProvider" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="AdminHeader.jsp"/>

<br/>
<!-- Content -->
<body style="background-color:pink">
<div class="container">

<h1>Update Product</h1>
<form class="form-horizontal" action="UpdateProductProcess" method="post" enctype="multipart/form-data">
 
  <div class="form-group">
    <label class="control-label col-sm-2" for="productId" style="text-align:left;">Product Id :</label>
    <div class="col-sm-10" style="width:30%;">
    <input type="text" class="form-control" id="productId" name="productId" value="${requestScope.pObj.productId}" readonly="readonly">
    </div>
  </div>
 
  <div class="form-group">
    <label class="control-label col-sm-2" for="productName" style="text-align:left;">Product Name :</label>
    <div class="col-sm-10" style="width:30%;">
    <input type="text" class="form-control" id="productName" name="productName" value="${requestScope.pObj.productName}">
    </div>
  </div>
 
 	 <div class="form-group">
    <label class="control-label col-sm-2" for="productDesc" style="text-align:left;">Product Description :</label>
    <div class="col-sm-10" style="width:30%;">
    <textarea type="text" class="form-control" id="productDesc" name="productDesc" rows="10" cols="15">
    ${requestScope.pObj.productDesc}
    </textarea>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="price" style="text-align:left;">Product Price :</label>
    <div class="col-sm-10" style="width:30%;">
    <input type="text" class="form-control" id="price" name="price" value="${requestScope.pObj.price}">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="image" style="text-align:left;">Product Image :</label>
    <div class="col-sm-10" style="width:30%;">
    <input type="file" class="form-control" id="image" name="image">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="quantity" style="text-align:left;">Product Quantity :</label>
    <div class="col-sm-10" style="width:30%;">
    <input type="text" class="form-control" id="quantity" name="quantity" value="${requestScope.pObj.quantity}">
    </div>
  </div>
  
   <div class="form-group">
  <label class="col-sm-2 control-label" for="product_categorie">PRODUCT CATEGORY</label>
  <div class="col-sm-4">
    <select id="product_categorie" name="product_categorie" class="form-control input-sm">
    	<option value="0">---Select category--------</option>
    	<c:forEach items="${cList}" var="cObj">
    		<option value="${cObj.categoryId}">${cObj.categoryName}</option>
    	</c:forEach>
    </select>
  </div>
</div>
 
 
  
    <button type="submit" class="btn btn-default" style="margin-left:200px;">Update Product</button>
</form>


 </div>
 

<br/><br/><br/>
</body>
<jsp:include page="Footer.jsp"/>
