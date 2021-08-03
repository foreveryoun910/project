<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form id="frm" name="frm" action="memberInsert.do" method="post">
			<h1 class="h3 mb-2 text-gray-800">회원가입</h1>
			<br>
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
											<td width="400"><input type="text" id="id" name="id"
												size="40" placeholder="아이디 입력" required="required">
											</td>
										</tr>
										<tr>
											<th width="150">패스워드</th>
											<td width="400"><input type="password" id="password"
												name="password" size="40" placeholder="패스워드 입력"
												required="required"></td>
										</tr>
										<tr>
											<th width="150">패스워드 확인</th>
											<td width="400"><input type="password" id="passcheck"
												name="passcheck" size="40" placeholder="패스워드 확인"
												required="required"></td>
										</tr>
										<tr>
											<th width="150">이름</th>
											<td width="400"><input type="text" id="name" name="name"
												size="40" placeholder="이름 입력" required="required"></td>
										</tr>
										<tr>
											<th width="150">닉네임</th>
											<td width="400"><input type="text" id="nickname"
												name="nickname" size="40" placeholder="닉네임 입력"
												required="required">&nbsp;&nbsp;<span><font size="2" color="lightgray">닉네임은 6글자까지</font></span></td>
										</tr>
										<tr>
											<th width="150">이메일</th>
											<td width="400"><input type="text" id="email"
												name="email" size="40" placeholder="이메일 입력"
												required="required"></td>
										</tr>
										<tr>
											<th width="150">이메일수신동의</th>
											<td><input type="checkbox" id="emailck" name="emailck"
												value="이메일체크" required="required">이메일 수신을 동의합니다.</td>
										</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br>
			<div>
				<button type="submit" class="btn btn-success">회원가입</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-success">취소</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-success"
					onclick="location.href='home.do'">HOME</button>
			</div>
		</form>
	</div>
	<br>
	<br>
</body>
</html>