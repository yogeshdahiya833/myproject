<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Men'sTrend</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Men'sTrend</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Home.jsp">Home</a></li>
     
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Shop By Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
           
          <li><a href="viewAllCategories">View All Categories</a></li>
          <li><a href="ViewAllProduct">View All Products</a></li>
        </ul>
      </li>
      <li><a href="About.jsp">About Us</a></li>
    </ul>
    <div class="container">
   		<div class="dark">
   			<form action="search" role="Product Search" style="width:250px; margin-top:10px; margin-left:650px;">
  			 <div class ="input-group">
   			<input type="text" class="form-control" placeholder="Search" name="Search"/>
   			<div class="input-group-btn">
   		<button type="submit" class="btn btn-default">
   			<span class="glyphicon glyphicon-search"></span>
   		</button>
   			</div>
   			</div>
   		</form>
   	</div>
   </div>
         <div style="margin-top:-50px; margin-right:40px;">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li></ul>
          <ul class="nav navbar-nav navbar-right">
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
  </div>
</nav>
  




