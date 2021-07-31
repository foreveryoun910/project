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
			frm.action = 'memberDelete.do';
			frm.submit();
			return true;
		}
	</script>		
</head>
<body>
	<div align="center">
		<div>
			<form id="frm" name="frm" action="memberUpdateForm.do" method="post">
				<table border="1" style="border-collapse: collapse;">
					<tr>
						<th width="150">아이디</th>
						<td width="400">${member.id}<input type="hidden" id="id" name="id" value="${member.id}"></td>
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
				</table>
				<br>
				<div>
					<button type="submit">회원정보변경</button>
					&nbsp;&nbsp;&nbsp;
					<input type='button' value='회원탈퇴' onclick='return submit2(this.form);'>
				</div>
			</form>
		</div>
	</div>
</body>
</html>