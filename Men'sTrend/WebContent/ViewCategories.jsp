
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

<body style="background-color:pink">

	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>

	<br/><br/><br/>
	<div class="container">

	
<h1>List of Categories</h1>
	<c:choose>
		<c:when test="${cList.size() eq 0}">
			No Categories Found...
		</c:when>
		<c:otherwise>

			<table class="table table-hover">
				<tr>
			
					<th>Category Name</th>
					<th>Category Description</th>
					<th colspan="3">Operations</th>
				
				</tr>
				<c:forEach items="${cList}" var="categoryObj">
					<tr>
						
						<td>${categoryObj.categoryName}</td>
						<td>${categoryObj.categoryDesc}</td>
					 <c:if test="${sessionScope.user.role eq 'admin'}">						
						<td>
							<a href="deleteCategory?catId=${categoryObj.categoryId}"><i class="fa fa-trash" aria-hidden="true"></i></a>
						</td>
						<td>
							<a href="updateCategory?catId=${categoryObj.categoryId}"><i class="fa fa-edit" aria-hidden="true"></i></a>
						</td></c:if>
						 <c:if test="${sessionScope.user.role ne 'admin'}">
						<td>
							<a href="ViewAllProduct?categoryId=${categoryObj.categoryId}">View Products </a>
							
						</td></c:if>
	
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

 </div>
 </body>
 <jsp:include page="Footer.jsp"/>
 