<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function submit2(frm) {
		frm.action = 'memberDeleteAdmin.do';
		frm.submit();
		return true;
	}

	function submit3(frm) {
		frm.action = 'memberDeleteUser.do';
		frm.submit();
		return true;
	}
</script>
</head>
<body>
	<div class="container">
		<br> <br>
		<!-- Page Heading -->
		<div align="center">
			<form id="frm" name="frm" action="memberUpdateForm.do" method="post">
				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="row" style="float: none; margin: 100 auto;">
						<div class="col-lg-6" style="float: none; margin: 100 auto;">
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<tbody>
											<tr>
												<th width="150">아이디</th>
												<td width="400">${member.id}<input type="hidden"
													id="id" name="id" value="${member.id}"></td>
											</tr>
											<tr>
												<th width="150">패스워드</th>
												<td width="400">${member.password}</td>
											</tr>
											<tr>
												<th width="150">이름</th>
												<td width="400">${member.name}</td>
											</tr>
											<tr>
												<th width="150">닉네임</th>
												<td width="400">${member.nickname}</td>
											</tr>
											<tr>
												<th width="150">이메일</th>
												<td width="400">${member.email}</td>
											</tr>
										</tbody>
									</table>
								</div>
								<br>
								<button type="submit" class="btn btn-success">회원정보 수정</button>
								&nbsp;&nbsp;&nbsp;
								<c:if test="${ author eq 'ADMIN' }">
									<button type='button' class="btn btn-success"
										onclick='return submit2(this.form);'>회원탈퇴</button>
								</c:if>
								<c:if test="${ author eq 'USER' }">
									<button type='button' class="btn btn-success"
										onclick='return submit3(this.form);'>탈퇴</button>
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<br>
				<br>
			</form>
		</div>
	</div>



	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>
</body>
</html>