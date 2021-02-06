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
<br/>
<!-- Content -->
<body style="background-color:orange">

<div class="container">
<form class="form-horizontal" action="updateUser" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email address:</label>
    <div class="col-sm-10">
    <input type="email" class="form-control" id="email" name="email" value="${sessionScope.user.email}" readonly="readonly">
    </div>
  </div>
   
   <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10">
    <input type="password" class="form-control" id="pwd" name="pwd" value="${sessionScope.user.password}">
    </div>
  </div>
   
  <div class="form-group">
    <label class="control-label col-sm-2" for="fname">First Name:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="fname" name="fName" value="${sessionScope.user.firstName}" >
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="lname">Last Name:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="lname" name="lName" value="${sessionScope.user.lastName}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="gender">Gender:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="gender" name="gender" value="${sessionScope.user.gender}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="dob">Date Of Birth:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="dob" name="dob" value="${sessionScope.user.dateOfBirth }">
    </div>
  </div> 
  <button type="submit" class="btn btn-default">Update</button>
</form>

 </div>
 
</body>
<br/><br/><br/>
<jsp:include page="Footer.jsp"/>
