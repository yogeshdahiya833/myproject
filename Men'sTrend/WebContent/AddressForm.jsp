<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="UserHeader.jsp"/>

<br/>
<!-- Content -->
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("Images/man11.jpg");

  min-height: 800px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
</style>
<div class="bg-img">
<div class="container">

<c:if test="${not empty msg}">
	<div class="alert alert-info">
		${msg}
	</div>
</c:if>




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
<jsp:include page="Footer.jsp"/>
 