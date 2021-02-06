<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="UserHeader.jsp"/>

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color:orange">
<h1 style="margin-left:490px;"><b>Address Form</b></h1>
<div class=container style="margin-top:80px;">

<form class="form-horizontal" action="UpdateAddressProcess" method="post">
 <c:if test="${not empty msg}">
		<div class="alert alert-danger">
			${msg}
		</div>
	</c:if>
	
<div class="form-group"> <!-- Street 1 -->
<label for="addressId" class="control-label col-sm-2"> Address Id</label>
 <div class="col-sm-10">
<input type="text" class="form-control" id="addressId" name="addressId" value="${requestScope.aObj.addressId}" readonly="readonly">
</div>
</div>



<div class="form-group"> <!-- Street 1 -->
<label for="addrLine1" class="control-label col-sm-2"> Address Line1</label>
 <div class="col-sm-10">
<input type="text" class="form-control" id="addrLine1" name="addrLine1" value="${requestScope.aObj.addressLine1}">
</div>
</div>
<div class="form-group"> <!-- Street 2 -->
<label for="addrLine2" class="control-label col-sm-2"> Address Line2</label>
 <div class="col-sm-10">
<input type="text" class="form-control" id="addrLine2" name="addrLine2" value="${requestScope.aObj.addressLine2}" >
</div>
</div>
<div class="form-group"> <!-- City-->
<label for="city" class="control-label col-sm-2">City/Town</label>
 <div class="col-sm-10">
<input type="text" class="form-control" id="city" name="city" value="${requestScope.aObj.city}">
</div>
</div>
<div class="form-group"> <!-- State Button -->
<label for="state" class="control-label col-sm-2">State</label>
 <div class="col-sm-10">
<input type="text" class="form-control" id="state" name="state" value="${requestScope.aObj.state}">
</div>
</div>
<div class="form-group"> <!-- Pin Code-->
<label for="pin" class="control-label col-sm-2">Pin Code</label>
 <div class="col-sm-10">
<input type="text" class="form-control" id="pin" name="pin"  value="${requestScope.aObj.pinCode}">
</div>
</div>

<div class="form-group"> <!-- Submit Button -->
<button type="submit" class="btn btn-primary" style="margin-left:500px; margin-top:20px;">Update</button>
</div> 
</form>
</div>
</body>
</html>