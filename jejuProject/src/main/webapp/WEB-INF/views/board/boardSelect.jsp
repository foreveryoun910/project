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
			<h1 class="h3 mb-2 text-gray-800">공지사항</h1>
			<br>
			<!-- DataTales Example -->
			<div class="card shadow mb-4">
				<div class="row" style="float: none; margin: 100 auto;">
					<div class="col-lg-9" style="float: none; margin: 100 auto;">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<tbody>

										<tr>
											<th width="100">No.</th>
											<td width="70" align="center">${board.bNo}</td>
											<th width="100">작성자</th>
											<td width="150" align="center">${board.bWriter}</td>
											<th width="100">작성일자</th>
											<td width="150" align="center">${board.bDate}</td>
											<th width="100">조회수</th>
											<td width="70" align="center">${board.bHit}</td>
										</tr>
										<tr>
											<th width="100">제목</th>
											<td colspan="7">${board.bTitle}</td>
										</tr>
										<tr>
											<th width="100">내용</th>
											<td colspan="7"><textarea rows="10" cols="100">${board.bContent}</textarea></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

				<div>
					<button type="button" class="btn btn-success"
						onclick="location.href='boardList.do'">목록</button>
					&nbsp;&nbsp;&nbsp;
					<c:if test="${author eq 'ADMIN' }">
					<button type="submit" class="btn btn-success"
						onclick="location.href='boardUpdateForm.do?bNo=${board.bNo}'">수정</button>
					&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-success"
						onclick="location.href='boardDelete.do?bNo=${board.bNo}'">삭제</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>





	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>
</body>
</html>