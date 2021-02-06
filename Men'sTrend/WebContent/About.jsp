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
<!------ Include the above in your HEAD tag ---------->
<body style="background:orange">

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <img src="Images/man1.jpg" style="width:1400px;height:400px;" alt="test" class="img-responsive" >
            <div class="carousel-caption">
              <h1>About Us</h1>
              <h1><b>Men'sTrend Online shopping store for men.</b></h1>
            </div>
          
         </div>
      </div>
      </div>   
   
   <div class="container">   
  <h3 style="text-align:center"> 
 In this form detailed explanation about the online shopping system is explained with experience and contact number.This details will give confidence for user before giving order.

  <br/><br></br>

	</h3>    
	</div>
	
	<div class="container">
  <div class="row margin-top-40">                 
   	 
	
	                 
   	 <div class="col-md-3 portfolio margin-bottom-20">
       <div class="box">
          <img src="Images/man2.jpg" style="width:800px;height:200px;" class="img-responsive" alt="">
            <div class="caption">
               <div class="caption-text">
               </div>
             </div>
        	</div>
   		
	</div>
	
                
   	 <div class="col-md-3 portfolio margin-bottom-20">
       <div class="box">
          <img src="Images/man7.jpg" style="width:800px;height:200px;" class="img-responsive" alt="">
            <div class="caption">
               <div class="caption-text">
               </div>
             </div>
        	</div>
   		
	</div>
	               
   	 <div class="col-md-3 portfolio margin-bottom-20">
       <div class="box">
          <img src="Images/man8.jpg" style="width:800px;height:200px;" class="img-responsive" alt="">
            <div class="caption">
               <div class="caption-text">
               </div>
             </div>
        	</div>
   		</div>
   		<div class="col-md-3 portfolio margin-bottom-20">
       <div class="box">
          <img src="Images/manswear1.jpg" style="width:800px;height:200px;" class="img-responsive" alt="">
            <div class="caption">
               <div class="caption-text">
               </div>
             </div>
        	</div>
   		</div>
	
	</div>
	</div>
	
  
	<div class="container">
  <div class="row margin-top-40">                 
   	
	          
   	</div>
	</div>	
	
 <div class="container">
    <div class="row">
        <div class="col-md-4">
         <span class="glyphicon glyphicon-map-marker" style="font-size:40px;">Address</span><br/><br/>
		<h5 style="margin-left:45px;">HIM College,Behind of Hindu Boys College,Guhana Road</h5>
		<h5 style="margin-left:45px;">Sonipat-131001, Haryana, India</h5>
		
        </div>
    </div>
  
  
       
  
    <div class="row">
      
        <div class="col-md-4" style="margin-left:400px; margin-top:-120px">
         <span class="glyphicon glyphicon-earphone" style="font-size:40px;">&nbsp;Phone</span><br/><br/>
         <h5 style="margin-left:80px;">8529826307</h5>
        <h5 style="margin-left:80px;">9729123107</h5>
        </div>
    </div>

       
 
    <div class="row">
      
       <div class="col-md-4"style="margin-left:800px; margin-top:-120px">
         <span class="glyphicon glyphicon-envelope" style="font-size:40px;">&nbsp;E-Mail</span><br/><br/>
         
         <h5 style="margin-left:80px;">yogeshdahiya@gmail.com</h5>
        </div>
    </div>
   </div>
  </div>
<!-- Content -->

<!-- Content -->

 </body>