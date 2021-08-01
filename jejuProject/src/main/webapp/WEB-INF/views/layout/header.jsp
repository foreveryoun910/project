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
</head>

<body>
<section id="top">
	<div class="container">
		<div class="row">
			<div class="col-lg-7">
				<p class="contact-action">
					IN CASE OF ANY QUESTIONS, CALL
					THIS NUMBER: <strong>053-421-2460</strong>
				</p>
			</div>
			<div class="col-lg-3 clearfix">
				<ul class="login-cart">
				<c:if test = "${ empty nickname }">
					<li><a data-toggle="modal" data-target="#myModal" href="#">LOGIN</a></li>
					<li><a href="memberInsertForm.do">SIGN UP</a></li>
				</c:if>	
				<c:if test = "${ not empty nickname }">
					<li>
						<div>
							<a href="logout.do">LOGOUT</a>
						</div>
					</li>
				</c:if>	
				</ul>
			</div>
			<div class="col-lg-2">
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
				
				<div class="modal-body clearfix">
					<form action="" method="post" id="login_form" class="std">
						<fieldset>
							<h3>Already registered?</h3>
							<div class="form_content clearfix">
								<p class="text">
									<label for="email">E-mail address</label> <span><input
										placeholder="E-mail address" type="text" id="email"
										name="email" value="" class="account_input"></span>
								</p>
								<p class="text">
									<label for="passwd">Password</label> <span><input
										placeholder="Password" type="password" id="passwd"
										name="passwd" value="" class="account_input"></span>
								</p>
								<p class="lost_password">
									<a href="#popab-password-reset" class="popab-password-link">Forgot
										your password?</a>
								</p>
								<p class="submit">
									<button class="btn btn-success">Log in</button>
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
				<li class="dropdown"><a href="#"> MY PAGE <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#" onclick="getRecord('${id}')">My Page</a></li>
						<li><a href="#">Member Management</a></li>
					</ul></li>
				<!-- End of /.dropdown -->

<!-- 				<c:if test = "${ not empty nickname }">
				<li class="dropdown"><a href="#"> MY PAGE <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">My Page</a></li>
						<c:if test = "${ author eq 'ADMIN' }">
							<li><a href="#">My Page</a></li>
							<li><a href="#">Member Management</a></li>
						</c:if>	
					</ul></li>
				</c:if> -->

			</ul>
			<!-- End of /.nav-main -->
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- End of /.nav -->
</body>