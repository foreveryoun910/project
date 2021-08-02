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
			frm.iNo.value = n;
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
					<th width="100">말머리</th>
					<th width="70">글 번호</th>
					<th width="300">글 제목</th>
					<th width="150">작성자</th>
					<th width="150">작성일자</th>
					<th width="70">조회수</th>
				</tr>
				<c:forEach var="info" items="${list}">
					<tr onmouseover="this.style.background='yellow'" onmouseout="this.style.background='white'" onclick="getRecord(${info.iNo})">
						<td align="center">${info.iSubject}</td>
						<td align="center">${info.iNo}</td>
						<td>${info.iTitle} <span><font color="lightgray">[${info.iAno}]</font></span></td>
						<td align="center">${info.iWriter}</td>
						<td align="center">${info.iDate}</td>
						<td align="center">${info.iHit}</td>							
					</tr>
				</c:forEach>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='home.do'">go home</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='infoInsertForm.do'">write</button>
		</div>
		
		<form id="frm" name="frm" action="infoSelect.do" method="post">
			<input type="hidden" id="iNo" name="iNo">	
		</form>
	</div>
</body>
</html>