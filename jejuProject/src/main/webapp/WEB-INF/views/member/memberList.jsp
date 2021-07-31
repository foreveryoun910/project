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
	<div align="center">
		<div><h1>전체회원보기</h1></div>
		<div>
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<th width="70">회원번호</th>
					<th width="70">회원아이디</th>
					<th width="300">회원비밀번호</th>
					<th width="150">이름</th>
					<th width="150">닉네임</th>
					<th width="70">이메일</th>
					<th width="70">회원권한</th>
				</tr>
				<c:forEach var="member" items="${list}">
					<tr onmouseover="this.style.background = 'yellow'" onmouseout="this.style.background='white'" onclick="getRecord('${member.id}')">
						<td align="center">${member.no}</td> <!-- 여기 쓰는 id는 vo와 일치(대소문자 구분) -->
						<td align="center">${member.id}</td>
						<td align="center">${member.password}</td>
						<td align="center">${member.name}</td>
						<td align="center">${member.nickname}</td>
						<td align="center">${member.email}</td>
						<td align="center">${member.author}</td>
					</tr>
				</c:forEach>
			</table>
		</div><br>
	</div>
	<div>
		<form id="frm" name="frm" action="memberSelect.do" method="post">
			<input type="hidden" id="id" name="id">
		</form>
	</div>
</body>
</html>