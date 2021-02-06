<jsp:include page="AdminHeader.jsp"/>

<br/>
<!-- Content -->
<body style="background-color:orange">
</body>

<div class="container">
<form class="form-horizontal" action="addCategory" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="categoryName"><h4><b>Category Name :</b></h4></label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="categoryName" name="categoryName" required>
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="desc"><h4><b>Category Desc:</b></h4></label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="desc" name="desc" required>
    </div>
  </div>
    <button type="submit" class="btn btn-default"><b>Add Category</b></button>
</form>

 </div>
 

<br/><br/><br/>	
<br/><br/><br/>	
<br/><br/><br/>	
<br/><br/><br/>	

<br/><br/><br/>	

<jsp:include page="Footer.jsp"/>
