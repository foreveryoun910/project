<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function submit2(frm) {
		frm.action = 'memberSelect.do';
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
			<form id="frm" name="frm" action="memberUpdate.do" method="post">
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
												<td width="400"><input type="password" id="password"
													value="${member.password}" name="password"
													placeholder="패스워드 입력" size="30" required="required"></td>
											</tr>
											<tr>
												<th width="150">이름</th>
												<td width="400">${member.name}</td>
											</tr>
											<tr>
												<th width="150">닉네임</th>
												<td width="400"><input type="text" id="nickname"
													value="${member.nickname}" name="nickname"
													placeholder="닉네임 입력" size="30" required="required"></td>
											</tr>
											<tr>
												<th width="150">이메일</th>
												<td width="400"><input type="text" id="email"
													name="email" value="${member.email}" size="30" placeholder="이메일 입력"
													required="required"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div>
					<button type="submit" class="btn btn-success">수정</button>
					&nbsp;&nbsp;&nbsp;
					<button type='button' class="btn btn-success"
						onclick='return submit2(this.form);'>돌아가기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>