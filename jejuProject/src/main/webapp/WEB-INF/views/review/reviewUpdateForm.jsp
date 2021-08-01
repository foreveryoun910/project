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
		<div><h1>게시글 수정</h1></div>
		<form id="frm" name="frm" action="reviewUpdate.do" method="post">
				<div>
				<table border="1" style="border-collapse: collapse;">
					<tr>
						<th width="100">글 번호</th>
						<td width="70" align="center">${review.rNo}<input type="hidden" id="rNo" name="rNo" value="${review.rNo}"></td>
						<th width="100">작성자</th>
						<td width="150" align="center">${review.rWriter}</td>
						<th width="100">작성일자</th>
						<td width="150" align="center">${review.rDate}</td>
						<th width="100">조회수</th>
						<td width="70" align="center">${review.rHit}</td>						
					</tr>
					<tr>
						<th width="100">글 제목</th>
						<td colspan="7"><input type="text" id="rTitle" name="rTitle" size="106" required="required" value="${review.rTitle}"></td>
					</tr>
					<tr>
						<th width="100">글 내용</th>
						<td colspan="7"><textarea rows="7" cols="110" id="rContent" name="rContent" required="required">${review.rContent}</textarea></td>
					</tr>
				</table>
				</div><br>
				<div>
					<button type="submit">수정</button>&nbsp;&nbsp;&nbsp;
					<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='reviewList.do'">목록</button>
				</div>
		</form>
	</div>
</body>
</html>