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
		<div>	<!-- 메뉴부분 -->
		${message}
		    <ul>
		      <c:if test = "${ empty nickname }">
		          <button type="button" onclick="location.href='loginForm.do'">로그인</button>&nbsp;&nbsp;&nbsp;
		          <button type="button" onclick="location.href='memberInsertForm.do'">회원가입</button>
		      </c:if>
		      <c:if test = "${ not empty nickname }">
		      	  <button type="button" onclick="location.href='logout.do'">로그아웃</button>&nbsp;&nbsp;&nbsp;
		      	  <button type="button" onclick="getRecord('${id}')">내정보</button>
			      <li><a href="#contact">Contact</a></li>
			      <li><a href="#about">About</a></li>
			      <c:if test = "${ author eq 'ADMIN' }"> <!-- 관리자로 로그인했을 때만 보여주기 -->
				      <li><a href="#about">Members</a></li>
				      <button type="button" onclick="location.href='memberList.do'">전체회원조회</button> 
			      </c:if>
		      </c:if>
		    </ul>
		</div>
		<div>
			<button type="button" onclick="location.href='boardList.do'">공지사항게시판</button>
			<button type="button" onclick="location.href='reviewList.do'">여행후기게시판</button>
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
						<img
							src="<%=request.getContextPath()%>/resource/images/01.jpg"
							alt="" /> <img
							src="<%=request.getContextPath()%>/resource/images/03.jpg"
							alt="" />
					</div>
					<!-- End of /.nivoslider -->
				</div>
				<!-- End of /.col-md-12 -->
			</div>
			<!-- End of /.row -->
		</div>
		<!-- End of /.container -->
	</section><br><br>
	<!-- End of Section -->
</body>
</html>