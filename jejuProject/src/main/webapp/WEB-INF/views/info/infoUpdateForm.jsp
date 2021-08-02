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
		<form id="frm" name="frm" action="infoUpdate.do" method="post">
				<div>
				<table border="1" style="border-collapse: collapse;">
					<tr>
						<th width="100">말머리</th>
						<td width="100">
							<select id="iSubject" name="iSubject">
								<option selected>${list[0].iSubject}</option>
								<option value="맛집">맛집</option>
								<option value="숙소">숙소</option>
								<option value="렌터카">렌터카</option>
							</select>
						</td>
						<th width="100">글 번호</th>
						<td width="70" align="center">${list[0].iNo}<input type="hidden" id="iNo" name="iNo" value="${list[0].iNo}"></td>
						<th width="100">작성자</th>
						<td width="150" align="center">${list[0].iWriter}</td>
						<th width="100">작성일자</th>
						<td width="150" align="center">${list[0].iDate}</td>
						<th width="100">조회수</th>
						<td width="70" align="center">${list[0].iHit}</td>						
					</tr>
					<tr>
						<th width="100">글 제목</th>
						<td colspan="7"><input type="text" id="iTitle" name="iTitle" size="106" required="required" value="${list[0].iTitle}"></td>
					</tr>
					<tr>
						<th width="100">글 내용</th>
						<td colspan="7"><textarea rows="7" cols="110" id="iContent" name="iContent" required="required">${list[0].iContent}</textarea></td>
					</tr>
				</table>
				</div><br>
				<div>
					<button type="submit">수정</button>&nbsp;&nbsp;&nbsp;
					<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='infoList.do'">목록</button>
				</div>
		</form>
	</div>
</body>
</html>