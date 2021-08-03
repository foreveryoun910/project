<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>WELCOME JEJU</title>

	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:400,700' rel='stylesheet' type='text/css'>

	<!-- Css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/nivo-slider.css" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/owl.carousel.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/owl.theme.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/responsive.css">

	<!-- jS -->
	<script src="<%=request.getContextPath()%>/resource/js/jquery.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resource/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resource/js/jquery.nivo.slider.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resource/js/owl.carousel.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resource/js/jquery.nicescroll.js"></script>
	<script src="<%=request.getContextPath()%>/resource/js/jquery.scrollUp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/js/main.js" type="text/javascript"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="header" ignore="true" />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="body" ignore="true" />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="footer" ignore="true" />
			</div>
		</div>		
	</div>
</body>
</html>