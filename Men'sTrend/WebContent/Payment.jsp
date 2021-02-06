<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<jsp:include page="UserHeader.jsp"/>
<br/><br/>
<!------ Include the above in your HEAD tag ---------->

<body style="background-image:url(https://www.codewithc.com/wp-content/uploads/2015/05/online-shopping-cart-using-php.jpg);">
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    <div class="checkbox pull-right">
                        <label>
                            <input type="checkbox" />
                            Remember
                        </label>
                    </div>
                </div>
                <div class="panel-body">
                    <form role="form" action="processPayment" method="post">
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="number" class="form-control" id="cardNumber" maxLength="16" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                            
                                    <select class="input-block-level">
                    				<option>January</option>
                    				<option>February</option>
                    				<option>March</option>
                    				<option>April</option>
                    				<option>May</option>
                    				<option>June</option>
                    				<option>July</option>
                    				<option>August</option>
                    				<option>September</option>
                    				<option>October</option>
                    				<option>November</option>
                   					<option>December</option>
                  					</select>
    							</div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                   <select class="input-block-level">
                                   <option>2020</option>
                                   <option>2021</option>
                                   <option>2022</option>
                                   <option>2023</option>
                                   <option>2024</option>
                                   </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CVV CODE</label>
                                <input type="password" class="form-control" id="cvCode" maxLength="3" placeholder="CVV" required />
                            </div>
                        </div>
                    </div>
                              	</form>  
                </div>
            </div>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a><span class="badge pull-right"><span class="glyphicon glyphicon-rupee"></span>Rs. ${sessionScope.total+50}</span> Final Payment</a>
                </li>
            </ul>
            <br/>
            
              <input type="submit" class="btn btn-success btn-lg btn-block" value="Pay"/>
        </div>
    </div>
</div>
<br/><br/><br/>

<style>
	body { margin-top:0px; }
.panel-title {display: inline;font-weight: bold;}
.checkbox.pull-right { margin: 0; }
.pl-ziro { padding-left: 0px; }
</style>
</body>
<jsp:include page="Footer.jsp"/>
