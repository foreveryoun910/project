<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${nickname} 님 로그인 성공!
	
	<form id="frm" name="frm" action="logout.do" method="post">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>