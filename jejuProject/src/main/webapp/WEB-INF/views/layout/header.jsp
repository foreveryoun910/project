<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!-- TOP HEADER Start
    ================================================== -->
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function getRecord(n) {
			frm.id.value = n;
			frm.submit();
		}
	</script>
	
	<style>
		/*	Login Modal Start
		    ==================================================*/
		
		
		#create-account_form, #login_frm {
			float: center;
			text-align: center;
			width: 90%;
		}
		#create-account_form {
			margin-right: 11px;
			margin-top: 0;
			min-height: 245px;
		}
		#create-account_form h3,
		#login_frm h3 {
			background: none repeat scroll 0 0 #90c322;
			color: #FFFFFF;
			padding:8px 0;
			font-size: 24px;
		}
		#authentication #create-account_form .form_content,
		#authentication #login_frm .form_content {
			min-height: 185px;
			padding: 15px 10px;
		}
		#create-account_form h4 {
			font-size: 18px;
			font-weight: normal;
			margin: 0 10px;
			padding-bottom: 22px;
			text-align: left;
		}
		#create-account_form #email_create,
		#login_frm #email,
		#login_frm #passwd,
		#login_frm #login_email,
		#login_frm #login_passwd {
			height: auto;
			padding: 5px;
			width: 220px;
			border: 1px solid #dedede;
		}
		
		
		#create-account_form .text label {
			display: none;
		}
		#create-account_form h3,
		#authentication #login_frm h3 {
			background: none repeat scroll 0 0 #212224;
			color: #FFFFFF;
		}
		#authentication #create-account_form .form_content,
		#authentication #login_frm .form_content {
			background: none repeat scroll 0 0 #F0F0F0 !important;
		}
		.text label {
			display: none;
		}
		#login_frm > fieldset ,
		#create-account_form > fieldset {
			background: #f5f5f5;
		}
	</style>
</head>

<body>
<section id="top">
	<div class="container">
		<div class="row">
			<div class="col-lg-7 col-md-7 col-7">
				<p class="contact-action">
					IN CASE OF ANY QUESTIONS, CALL
					THIS NUMBER: <strong>053-421-2460</strong>
				</p>
			</div>
			
			<div class="col-lg-3 col-md-3 col-3 clearfix">
				<ul class="login-cart">
				<c:if test = "${ empty id }">
					<li><a data-toggle="modal" data-target="#myModal" href="#">LOGIN</a></li>
					<li><a href="memberInsertForm.do">SIGN UP</a></li>
				</c:if>	
				<c:if test = "${ not empty id }">
					<li>
						<div>
							<a href="logout.do">LOGOUT</a>
						</div>
					</li>
				</c:if>	
				</ul>
			</div>
			
			<div class="col-lg-2 col-md-2 col-2">
				<div class="search-box">
					<div class="input-group">
						<input placeholder="Search Here" type="text" class="form-control">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button"></button>
						</span>
					</div>
					<!-- /.input-group -->
				</div>
				<!-- /.search-box -->
			</div>
		</div>
		<!-- End Of /.row -->
	</div>
	<!-- End Of /.Container -->


	<!-- MODAL Start
    	================================================== -->

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">LOG-IN</h4>
				</div>
				
				
				<div align="center" class="modal-body clearfix">
					<form id="login_frm" action="login.do" method="post" class="std">
						<fieldset>
							<h3>Already registered?</h3>
							<div class="form_content clearfix">
								<p class="text">
									<label for="id">ID</label>
									<span><input type="text" id="id" name="id" size="30" value="" class="account_input" placeholder="Enter your ID"></span>
								</p>
								<p class="text">
									<label for="password">Password</label>
									<span><input type="password" id="password" name="password" size="30" value="" class="account_input" placeholder="Enter your Password"></span>
								</p>
								<p class="lost_password">
									<a href="#popab-password-reset" class="popab-password-link">Forgot your password?</a>
								</p>
								<p class="submit">
									<button class="btn btn-success">Login</button>
								</p>
							</div>
						</fieldset>
					</form>
				</div>
				
				
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- End of /Section -->



<!-- LOGO Start
    ================================================== -->

<header>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<a href="home.do"> <H1>HELLO WELCOME TO JEJU</H1>
				</a>
			</div>
			<!-- End of /.col-md-12 -->
		</div>
		<!-- End of /.row -->
	</div>
	<!-- End of /.container -->
</header>
<!-- End of /Header -->




<!-- MENU Start
    ================================================== -->

<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<!-- End of /.navbar-header -->

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav nav-main">
				<li class="active"><a href="home.do">HOME</a></li>
				<li><a href="boardList.do">NOTICE</a></li>
				<li><a href="reviewList.do">TRAVEL REVIEW</a></li>
				<li><a href="infoList.do">INFORMATION BOARD</a></li>
				<c:if test = "${ not empty id }">
				
				<li class="dropdown"><a href="#"> MY PAGE <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#" onclick="getRecord('${sessionScope.id}')">My Page</a></li>
						<c:if test = "${ author eq 'ADMIN' }">
							<li><a href="memberList.do">Member Management</a></li>
						</c:if>	
					</ul></li>
				</c:if>

			</ul>
			<!-- End of /.nav-main -->
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- End of /.nav -->
</body>