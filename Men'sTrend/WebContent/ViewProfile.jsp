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

<c:if test="${not empty msg}">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>

<body style="background-color:orange">
<div class="container table-responsive">          
  <table class="table table-striped">
      <tr>
      	<td>Email </td>
      	<td>${sessionScope.user.email}</td>
      </tr>
      <tr>
      	<td>First Name </td>
      	<td>${sessionScope.user.firstName}</td>
      </tr>
      <tr>
      	<td>Last Name </td>
      	<td>${sessionScope.user.lastName}</td>
      </tr>
      <tr>
      	<td>Gender </td>
      	<td>${sessionScope.user.gender}</td>
      </tr>
  </table>
  </div>
<br/><br/><br/><br/><br/><br/><br/><br/>
<jsp:include page="Footer.jsp"/>
