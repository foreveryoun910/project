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
		<div><h1>정보게시판 글 보기</h1></div>
		<div>
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<th width="100">말머리</th>
					<td width="70" align="center">${info.iSubject}</td>
					<th width="100">글 번호</th>
					<td width="70" align="center">${info.iNo}</td>
					<th width="100">작성자</th>
					<td width="150" align="center">${info.iWriter}</td>
					<th width="100">작성일자</th>
					<td width="150" align="center">${info.iDate}</td>
					<th width="100">조회수</th>
					<td width="70" align="center">${info.iHit}</td>						
				</tr>
				<tr>
					<th width="100">글 제목</th>
					<td colspan="7">${info.iTitle}</td>
				</tr>
				<tr>
					<th width="100">글 내용</th>
					<td colspan="7"><textarea rows="7" cols="110">${info.iContent}</textarea></td>
				</tr>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='infoList.do'">목록</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" onclick="location.href='infoUpdateForm.do?iNo=${info.iNo}'">수정</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" onclick="location.href='infoDelete.do?iNo=${info.iNo}'">삭제</button>
		</div>
	</div>
</body>
</html>