<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.user.role eq 'admin'}">
<jsp:include page="AdminHeader.jsp"/>
</c:if>
<c:if test="${sessionScope.user.role eq 'user'}">
<jsp:include page="UserHeader.jsp"/>
</c:if>
<header style="margin-top: -20px;">
</header>
<c:if test="${not empty msg}">
	<div class="alert alert-info">
		${msg}
	</div>
</c:if>

<link rel="stylesheet" href="css/Login.css"/>
<div class="login-wrap">
		<div class="login-html">
		<div class="box">
		<label for="tab-1" class="tab">Change Password</label>
	<div class="login-form">
		<div class="sign-in-htm">
		<form action="ChangePasswordControllers" method="post">
			<div class="group">
			<label for="npass" class="label">New Password</label>
			<input id="npass" type="password" class="input" name="npwd" data-type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required/>
			</div>
				<div class="group">
				<label for="cpass" class="label">Confirm Password</label>
			<input id="cpass" type="password" class="input" name="cpwd" data-type="password" required/>
				</div>
			<div class="group">
			<input type="submit" class="button" value="Submit"/>
			</div>
		</form>
		</div>
	</div>
		</div>
		</div>
		</div>
		
		<div style="margin-bottom:25px">
	</div>
		
<jsp:include page="Footer.jsp"/>