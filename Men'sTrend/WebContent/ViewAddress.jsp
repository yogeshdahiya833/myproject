<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<jsp:include page="UserHeader.jsp"/>
<body style="background-color:orange">
<div class="container">
	
	<c:if test="${not empty aList}">
	<table>
		<tr>
			<td>Address Details </td>
			<td colspan="3">
				Operations
			</td>
		</tr>	
		<c:forEach items="${aList}" var="aObj">
		 
		<tr>
			<td>${aObj.addressLine1} , ${aObj.addressLine2} , ${aObj.city} , ${aObj.state}
			, ${aObj.pinCode}
				
				
			</td>
			
			<td>
			<a href="getOrderSummary?addressId=${aObj.addressId}" class="btn btn-info btn-sm">Deliver to this Address</a>
			</td>
			
			<td>
			<a href="UpdateAddress?addressId=${aObj.addressId}"><input type="submit" value="Update"/></a>
			</td>
			 
		</tr>
		</c:forEach>
	</table>
</c:if>
<div><h4>Want to Add another Address</h4></div>
<form class="form-horizontal" action="addAddress" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="addrLine1">Address Line 1:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="addrLine1" name="addrLine1">
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="addrLine2">Address Line 2:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="addrLine2" name="addrLine2">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="city">City :</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="city" name="city">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="state">State:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="state" name="state">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pincode">Pincode:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="pincode" name="pincode">
    </div>
  </div>
    <button type="submit" class="btn btn-default">Add</button>
</form>

 </div>
 </div>

	

</div>
