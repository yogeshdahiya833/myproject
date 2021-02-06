<jsp:include page="UserHeader.jsp"/>
 style>


    .header {
        
        font-size: 27px;
        padding: 10px;
    }

    .bigicon {
        font-size: 35px;
        
    }
</style>

<body style="background-image:url(https://images.pexels.com/photos/298864/pexels-photo-298864.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=2&h=650&w=940);">

<!-- Content -->
<div class="container" style="margin-top:50px;">

	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>
<div class="container">
    <div class="row">
        <div class="col-md-4">
       
            <div class="well well-sm">
                <form class="form-horizontal" action="contactController">
                    <fieldset>
                        <legend class="text-center header">Contact us</legend>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-10">
                                <input id="fName" name="fName" type="text" placeholder="First Name" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-10">
                                <input id="lName" name="lName" type="text" placeholder="Last Name" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                            <div class="col-md-10">
                                <input id="email" name="email" type="text" placeholder="Email Address" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-pencil-square-o bigicon"></i></span>
                            <div class="col-md-10">
                                <textarea class="form-control" id="Message" name="Message" placeholder="Enter your massage for us here..." rows="7"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-6 text-center">
                                <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <br><br><br>
         <div class="col-md-8">
        <h1>Contact Us</h1>
        <table class="table table-striped">
         <tr>
        <td style="text-align:center">contact:</td>
        <td>8529836307</td>
        </tr>
        
        <tr>
        <td style="text-align:center">Email Id:</td>
        <td>yogeshdahiya833@gmail.com</td>
        </tr>
        
         <tr>
        <td style="text-align:center">Address:</td>
         <td>VPO-Kanwali Teh-Kharkhoda, Sonipat-131403</td>
        </tr>
        
        
        
        </table>
    </div>
</div>
</div>
</div>
</body>
<jsp:include page="Footer.jsp"/>



