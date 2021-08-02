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
		<form id="frm" name="frm" action="boardUpdate.do" method="post">
			<div class="container">
				<!-- Page Heading -->
				<br> <br>
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
												<td width="70" align="center">${board.bNo}<input
													type="hidden" id="bNo" name="bNo" value="${board.bNo}"></td>
												<th width="100">작성자</th>
												<td width="150" align="center">${board.bWriter}</td>
												<th width="100">작성일자</th>
												<td width="150" align="center">${board.bDate}</td>
												<th width="100">조회수</th>
												<td width="70" align="center">${board.bHit}</td>
											</tr>
											<tr>
												<th width="100">제목</th>
												<td colspan="7"><input type="text" id="bTitle"
													name="bTitle" size="100" required="required"
													value="${board.bTitle}"></td>
											</tr>
											<tr>
												<th width="100">내용</th>
												<td colspan="7"><textarea rows="10" cols="100"
														id="bContent" name="bContent" required="required">${board.bContent}</textarea></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<br>
			<div>
				<button type="submit" class="btn btn-success">수정</button>
				&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-success"
					onclick="location.href='boardList.do'">목록</button>
			</div>
		</form>
	</div>
	<br>
	<br>
</body>
</html>