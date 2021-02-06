<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="UserHeader.jsp"/>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<body style="background-color:orange">

<div class="container">

	<c:if test="${empty cartList}">
		Cart is empty
	</c:if>
	<c:if test="${not empty cartList}">
    <div class="row">
    
    	
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach items="${cartList}" var="itemObj">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="Images/${itemObj.product.image}" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${itemObj.product.productName}</a></h4>
                                
                                <span>Status: </span><span class="text-success"><strong>
                                
                                In Stock
                                
                                </strong></span>
                                
                            
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1">                        
                        <a href="updateQuantity?itemId=${itemObj.itemId}"  class="btn-btn-default">
                            <span class="glyphicon glyphicon-add"></span> +
                        </a>
                        <input type="number" class="form-control text-center" value="${itemObj.quantity}"/>
                        
                        </td>
						
						 
                        <td class="col-sm-1 col-md-1 text-center"><strong>${itemObj.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${itemObj.price*itemObj.quantity}</strong></td>
                        <td class="col-sm-1 col-md-1">
                                                <td class="col-sm-1 col-md-1">
                        <a href="removeItem?itemId=${itemObj.itemId}"  class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </a></td>
                    </tr>
                    </c:forEach>
                    
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong>
                        	${sessionScope.total}
                        </strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>Rs. 50</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>Rs. ${sessionScope.total+50}</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="UserHome.jsp" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </a></td>
                        <td>
                        <a href="fetchAddresses" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
     </c:if>
</div>
</body>
    
    <jsp:include page="Footer.jsp"/>
    
   