<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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


	<!-- SLIDER Start
    ================================================== -->
	<div align="center">
		<div>
			${message}
		</div>
		<div>
			<form id="frm" name="frm" action="memberSelect.do" method="post">
				<input type="hidden" id="id" name="id">
			</form>
		</div>
	</div>

	<section id="slider-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div id="slider" class="nivoSlider">
						<img src="<%=request.getContextPath()%>/resource/images/01.jpg"
							alt="" /> <img
							src="<%=request.getContextPath()%>/resource/images/03.jpg" alt="" />
					</div>
					<!-- End of /.nivoslider -->
				</div>
				<!-- End of /.col-md-12 -->
			</div>
			<!-- End of /.row -->
		</div>
		<!-- End of /.container -->
	</section>
	<br>
	<br>
	<!-- End of Section -->
</body>
</html>