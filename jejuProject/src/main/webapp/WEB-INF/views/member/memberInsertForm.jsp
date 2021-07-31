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
		<div><h1>회원가입</h1></div>
		<div>
			<form id="frm" name="frm" action="memberInsert.do" method="post">
				<div>
					<table border="1" style="border-collapse: collapse;">
						<tr>
							<th width="150">아이디</th>
							<td width="400">
								<input type="text" id="id" name="id"  placeholder="아이디 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td width="400">
								<input type="password" id="password" name="password"  placeholder="패스워드 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">패스워드 확인</th>
							<td width="400">
								<input type="password" id="passcheck" name="passcheck"  placeholder="패스워드 확인" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">이름</th>
							<td width="400">
								<input type="text" id="name" name="name"  placeholder="이름 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">닉네임</th>
							<td width="400">
								<input type="text" id="nickname" name="nickname"  placeholder="닉네임 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">이메일</th>
							<td width="400">
								<input type="text" id="email" name="email"  placeholder="이메일 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">이메일수신동의</th>
							<td><input type="checkbox" id="emailck" name="emailck" value="이메일체크" required="required">이메일 수신을 동의합니다.</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='home.do'">홈으로 돌아가기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>