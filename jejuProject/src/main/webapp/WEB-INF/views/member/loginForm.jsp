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
		<form id="frm" name="frm" action="login.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th>아이디</th>
						<td><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" id="password" name="password"></td>
					</tr>
				</table><br>
			</div>
			<div>
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
</html>