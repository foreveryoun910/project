<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>여행후기게시판 상세 보기</h1></div>
		<div>
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<th width="100">글 번호</th>
					<td width="70" align="center">${list[0].rNo}</td>
					<th width="100">작성자</th>
					<td width="150" align="center">${list[0].rWriter}</td>
					<th width="100">작성일자</th>
					<td width="150" align="center">${list[0].rDate}</td>
					<th width="100">조회수</th>
					<td width="70" align="center">${list[0].rHit}</td>						
				</tr>
				<tr>
					<th width="100">글 제목</th>
					<td colspan="7">${list[0].rTitle}</td>
				</tr>
				<tr>
					<th width="100">글 내용</th>
					<td colspan="7"><textarea rows="7" cols="110">${list[0].rContent}</textarea></td>
				</tr>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='reviewList.do'">목록</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" onclick="location.href='reviewUpdateForm.do?rNo=${list[0].rNo}'">수정</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" onclick="location.href='reviewDelete.do?rNo=${list[0].rNo}'">삭제</button>
		</div><br><br>
		<div>
			<!-- 댓글 보여주는 코드 -->
			<table border="1">
					<c:if test="${list[0].rAno != 0}">
							<tr>
								<!-- 아이디,작성날짜 -->
								<td width="150">
									<div>${list[0].rcName}<br><font size="2" color="lightgray">${list[0].rcDate}</font></div>
								</td>
								<!-- 댓글내용 -->
								<td width="500">
									<div class="text_wrapper">${list[0].rcContent}</div>
								</td>
									<!-- 댓글 작성자만 수정,삭제 가능하도록 -->
									<c:if test="${list[0].rcName == sessionScope.id}">
										<a href="#">[수정]</a>
										<a href="#">[삭제]</a>
									</c:if>
								</td>
							</tr>
					</c:if>
			</table>
			<!-- 로그인 했을 경우만 댓글 작성 가능 -->
			<table>
				<c:if test="${sessionScope.id != null}">
					<tr bgcolor="#F5F5F5">
						<form id="reviewCommentInsertForm" action="">
							<input type="hidden" name="rNo" value="${list[0].rNo}">
							<input type="hidden" name="rcName" value="${sessionScope.id}">
							<!-- 닉네임 -->
							<td width="150">
								<div>${sessionScope.nickname}</div>
							</td>
							<!-- 댓글 작성 -->
							<td width="550">
								<div><textarea name="rcContent" rows="4" cols="70"></textarea></div>
							</td>
							<!-- 댓글 등록 버튼 -->
							<td width="100">
								<div id="btn" style="text-align:center;">
									<p><a href="#" onclick="location.href='reviewCommentInsert.do'">[댓글등록]</a></p>
								</div>
							</td>
						</form>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>