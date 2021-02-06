<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="Header.jsp"/>
<header style="margin-top: -40px;"></header>
<br/>   
<c:if test="${not empty msg}">
<div class="alert alert-warning">
	 ${msg} 
	
</div>
</c:if>
<link rel="stylesheet" href="css/Login.css"/>
<div class="login-wrap">
		<div class="login-html">
		<div class="box">
		<label for="tab-1" class="tab">Login</label>
	<div class="login-form">
		<div class="sign-in-htm">
		<form action="validateUser" method="post">
			<div class="group">
			<label for="user" class="label">Username</label>
			<input id="user" type="text" class="input" name="email" required>
			</div>
				<div class="group">
				<label for="pass" class="label">Password</label>
			<input id="pass" type="password" class="input" name="pwd" data-type="password" required>
				</div>
		<div class="group">
		<input id="check" type="checkbox" class="check" checked>
		<label for="check"><span class="icon"></span> Keep me Logged in</label>
		</div>
			<div class="group">
			<input type="submit" class="button" value="Sign In">
			</div>
				<div class="hr"></div>
				<a href="Signup.jsp">Create a New Account</a>
				</div>
		</form>
		</div>
	</div>
		</div>
		</div>
		
		<div style="margin-bottom:25px">
	</div>
		
<jsp:include page="Footer.jsp"/>