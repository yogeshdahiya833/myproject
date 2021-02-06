<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="AdminHeader.jsp"/>

<br/>
<!-- Content -->
<body style="background-color:pink">
<div class="container">
<form class="form-horizontal" action="addProduct" method="post" enctype="multipart/form-data">


  <div class="form-group">
    <label class="control-label col-sm-2" for="productName">Product Name :</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="productName" name="productName" required>
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="price">Price :</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="price" name="price" required>
    </div>
    <br/><br/><br/>
    <div class="form-group">
  <label class="col-sm-2 control-label" for="product_description">Product desc :</label>
  <div class="col-sm-4">                     
    <textarea class="form-control" id="product_description" name="product_description" required></textarea>
  </div>
</div>
    
    <div class="form-group">
    <label class="control-label col-sm-2" for="image">Image:</label>
    <div class="col-sm-4">
    <input type="file" class="form-control" id="image" name="image" required>
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
  <div class="form-group">
  <label class="col-sm-2 control-label" for="available_quantity">AVAILABLE QUANTITY</label>  
  <div class="col-md-4">
  <input id="available_quantity" name="available_quantity" placeholder="AVAILABLE QUANTITY" class="form-control input-md" required="" type="text">
  </div>
</div>
  
  
    <button type="submit" class="btn btn-default">Add Product</button>
</form>

 </div>
 
</div>
<br/><br/><br/>
</body>
<jsp:include page="Footer.jsp"/>
