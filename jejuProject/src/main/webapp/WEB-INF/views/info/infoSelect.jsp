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
	<div class="container">
		<!-- Page Heading -->
	<div align="center">
			<h1 class="h3 mb-2 text-gray-800">제주도 여행정보</h1>
			<br>
			<!-- DataTales Example -->
			<div class="card shadow mb-4">
				<div class="row" style="float: none; margin: 100 auto;">
					<div class="col-lg-10" style="float: none; margin: 100 auto;">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<tbody>
				<tr>
					<th width="120">말머리</th>
					<td width="70" align="center">${list[0].iSubject}</td>
					<th width="70">No.</th>
					<td width="70" align="center">${list[0].iNo}</td>
					<th width="100">작성자</th>
					<td width="150" align="center">${list[0].iWriter}</td>
					<th width="100">작성일자</th>
					<td width="150" align="center">${list[0].iDate}</td>
					<th width="100">조회수</th>
					<td width="70" align="center">${list[0].iHit}</td>						
				</tr>
				<tr>
					<th width="100">제목</th>
					<td colspan="9">${list[0].iTitle}</td>
				</tr>
				<tr>
					<th width="100">내용</th>
					<td colspan="9"><textarea rows="10" cols="110">${list[0].iContent}</textarea></td>
				</tr>
			</tbody>	
			</table>
		<div>
			<button type="button" class="btn btn-success" onclick="location.href='infoList.do'">목록</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" class="btn btn-success" onclick="location.href='infoUpdateForm.do?iNo=${list[0].iNo}'">수정</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" class="btn btn-success" onclick="location.href='infoDelete.do?iNo=${list[0].iNo}'">삭제</button>
		</div><br>
		
		<!-- 댓글 보여주는 곳 -->
<div class="card shadow mb-4">
	<div class="row" style="float: none; margin: 100 auto;">
<div class="col-lg-11" style="float: none; margin: 100 auto;">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable"
				width="100%" cellspacing="0">
				<tbody>
				<!-- 댓글목록 -->
					<c:if test="${list[0].iAno != 0}">
							<tr>
									<!-- 댓글번호.. -->
			<input type="hidden" id="icNo" name="icNo" value="${info.icNo}">
								<!-- 아이디,작성날짜 -->
								<td width="150" align="center">
									<div>${list[0].icName}<br><font size="2" color="lightgray">${list[0].icDate}</font></div>
								</td>
								<!-- 댓글내용 -->
								<td width="540">
									<div class="text_wrapper">${list[0].icContent}</div>
								</td>
								<td align="center">
									<!-- 댓글 작성자만 수정,삭제 가능하도록 -->
									<c:if test="${list[0].icName == sessionScope.id}">
										<a href="#">[수정]</a>
										<a href="#">[삭제]</a>
									</c:if>
								</td>
							</tr>
					</c:if>
					</tbody>
					</table>
					</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 댓글 보여주는 곳 -->
					</div>
				</div>
			</div>
		</div>
		<br>
		<div>
			<!-- 게시판 글 End -->			
			
			
			
			
			<div align="center">
			<!-- 로그인 했을 경우만 댓글 작성 가능 -->
			<form id="infoCommentInsertForm" action="">
			<table>
				<c:if test="${sessionScope.id != null}">
					<tr bgcolor="#F5F5F5" align="center">
							<input type="hidden" name="iNo" value="${list[0].iNo}">
							<input type="hidden" name="icName" value="${sessionScope.id}">
							<!-- 닉네임 -->
							<td width="150">
								<div>${sessionScope.nickname}</div>
							</td>
							<!-- 댓글 작성 -->
							<td width="530">
								<div><textarea name="icContent" rows="4" cols="70"></textarea></div>
							</td>
							<!-- 댓글 등록 버튼 -->
							<td width="100" align="center">
								<div id="btn" style="text-align:center;">
									<p><button type="button" class="btn btn-success" onclick="location.href='infoCommentInsert.do'">댓글등록</button></a></p>
								</div>
							</td>
					</tr>
				</c:if>
			</table>
			</form>
			</div>
		</div></div></div>
	</div><br><br>
</body>
</html>