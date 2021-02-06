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
<header style="margin-top: -20px;">

<div style="background-color:pink;height:100%">


<br/>
<!-- Content -->
<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>
	<h1>List of Contacts..</h1>
	<c:choose>
		<c:when test="${cList.size() eq 0}">
			No Contact Found...
		</c:when>
		<c:otherwise>
			<table class="table table-hover">
				<tr>
		
				
					<th>FName</th>
					<th>LName</th>
					<th>email</th>
					<th>Message</th>
					
					
					
				</tr>
				<c:forEach items="${cList}" var="sObj">
					<tr>
						
						
						<td>${sObj.firstName}</td>
						<td>${sObj.lastName}</td>
						<td>${sObj.email}</td>
						<td>${sObj.message}</td>
						
						 <td>
							<a href="DeleteContactController?email=${sObj.email}"><i class="fa fa-trash" aria-hidden="true"></i></a>
							
						</td>			
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
 </div>
 

</div>
