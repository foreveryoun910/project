<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function getRecord(n) {
			frm.bNo.value = n;
			frm.submit();
		}
	</script>	
</head>
<body>
	<div align="center">
		<div><h1>전체 공지 목록</h1></div>
		<div>
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<th width="70">글 번호</th>
					<th width="300">글 제목</th>
					<th width="150">작성자</th>
					<th width="150">작성일자</th>
					<th width="70">조회수</th>
				</tr>
				<c:forEach var="board" items="${list}">
					<tr onmouseover="this.style.background='yellow'" onmouseout="this.style.background='white'" onclick="getRecord(${board.bNo})">
						<td align="center">${board.bNo}</td>
						<td>${board.bTitle}</td>
						<td align="center">${board.bWriter}</td>
						<td align="center">${board.bDate}</td>
						<td align="center">${board.bHit}</td>							
					</tr>
				</c:forEach>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='home.do'">go home</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='boardInsertForm.do'">write</button>
		</div>
		
		<form id="frm" name="frm" action="boardSelect.do" method="post">
			<input type="hidden" id="bNo" name="bNo">	
		</form>
	</div>
</body>
</html>