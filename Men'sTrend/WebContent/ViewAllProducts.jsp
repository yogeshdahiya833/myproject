<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.user.role eq 'admin'}">
<jsp:include page="AdminHeader.jsp"/>
</c:if>
<c:if test="${sessionScope.user.role eq 'user'}">
<jsp:include page="UserHeader.jsp"/>
</c:if>

<c:if test="${empty sessionScope.user.role}">
<jsp:include page="Header.jsp"/>
</c:if>

	<br/><br/><br/><br/><br/><br/>
<!-- Content -->
<body style="background-color:pink">
<div class="container" style="margin-top:-900px">
	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>
	
	<h1 style="font-family:Monotype Corsiva; text-align:center; color:brown; font-size:30px; font-weight:bold">List of Products</h1>
	<br/>
	<c:choose>
		<c:when test="${pList.size() eq 0}">
		
			No Products Found...
			
		</c:when>
		<c:otherwise>
				<c:forEach items="${pList}" var="pObj">
				
	<div class="col-md-5 column productbox">
        <img src="Images/${pObj.image}" style="height:100px;width:100px" class="img-responsive">
        <div class="productName">${pObj.productName}</div>
        <div class="productDesc">${pObj.productDesc}</div>
        <div class="price">
        
        
        <c:if test="${sessionScope.user.role ne 'admin'}">
        
        <div class="pull-right">
        <a href="addToCart?Id=${pObj.productId}" class="btn btn-danger btn-sm" role="button">Add To Cart</a>
        </div>
        
        </c:if>
        
        <div class="pricetext">${pObj.price}</div></div>
        
        
       	<c:if test="${sessionScope.user.role eq 'admin'}">
        <a href="DeleteProductController?productId=${pObj.productId}" class="btn btn-primary"><i class="fa fa-trash " aria-hidden="true"></i>Delete</a>
		<a href="UpdateProductController?productId=${pObj.productId}" class="btn btn-primary"><i class="fa fa-edit"  aria-hidden="true"></i>Update</a>
		</c:if>
		
    </div>
									
				</c:forEach>
			
		</c:otherwise>
	</c:choose>
	
 </div>

 <style>
 	.productbox {
    background-color:#ffffff;
	padding:15px;
	margin-top:100px;
	margin-bottom:10px;
	height:40%;
	width:30%;
	-webkit-box-shadow: 0 8px 6px -6px  #999;
	   -moz-box-shadow: 0 8px 6px -6px  #999;
	        box-shadow: 0 8px 6px -6px #999;
}

.productName {
    font-weight:bold;
	padding:5px 0 5px 0;
}

.price {
	padding-bottom:10px;
	border-top:1px solid #dadada;
	font-weight:bold;
	font-size:1.4em;
}
 </style>
 </body>
 <jsp:include page="Footer.jsp"/>
 