<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<div class="container">

		<!-- Page Heading -->
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div align="center">
				<h1 class="h3 mb-2 text-gray-800">회원목록</h1>
				<br>
				<div class="row" style="float: none; margin: 100 auto;">
					<div class="col-lg-11" style="float: none; margin: 100 auto;">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover" id="dataTable"
									width="100%" cellspacing="0">
									<thead>
										<tr>
											<th width="60">회원번호</th>
											<th width="70">회원아이디</th>
											<th width="70">회원비밀번호</th>
											<th width="70">이름</th>
											<th width="70">닉네임</th>
											<th width="100">이메일</th>
											<th width="70">회원권한</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="member" items="${list}">
											<tr onclick="getRecord('${member.id}')">
												<td align="center">${member.no}</td>
												<!-- 여기 쓰는 id는 vo와 일치(대소문자 구분) -->
												<td align="center">${member.id}</td>
												<td align="center">${member.password}</td>
												<td align="center">${member.name}</td>
												<td align="center">${member.nickname}</td>
												<td align="center">${member.email}</td>
												<td align="center">${member.author}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div>
					<button type="button" class="btn btn-success"
						onclick="location.href='home.do'">HOME</button>
				</div>
			</div>
			<br>
			<br>


			<form id="frm" name="frm" action="memberSelect.do" method="post">
				<input type="hidden" id="id" name="id">
			</form>
		</div>
	</div>

	<!-- /.container -->


	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>
</body>
</html>