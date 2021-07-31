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
		<table>
			<c:forEach var="member" items="${list}">
				<tr onclick="getRecord('${member.id}')">
					<td>${member.id} : ${member.name} : ${member.nickname}
						${member.password} : ${member.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<form id="frm" name="frm" action="memberSelect.do" method="post">
			<input type="hidden" id="id" name="id">
		</form>
	</div>
</body>
</html>