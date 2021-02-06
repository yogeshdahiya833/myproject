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
      <a class="navbar-brand" href="#">Men'sTrend</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="AdminHome.jsp">Home</a></li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="AddCategory.jsp">Add Category</a></li>
          <li><a href="viewAllCategories">View All Categories</a></li>
          <li><a href="viewAllCategories?x=add">Add Product</a></li>
          <li><a href="ViewAllProduct">View All Products</a></li>

        </ul>
      </li>
      <li><a href="ViewContact">View Contacts</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome : ${sessionScope.user.firstName} ${sessionScope.user.lastName}<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="ViewProfile.jsp">View Profile</a></li>
          <li><a href="UpdateProfile.jsp">Update Profile</a></li>
          <li><a href="ChangePassword.jsp">Change Password</a></li>
          <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
        </ul>
      </li>
      
    </ul>
  </div>
</nav>
  




