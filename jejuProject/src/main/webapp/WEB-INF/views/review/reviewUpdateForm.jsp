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
		<form id="frm" name="frm" action="reviewUpdate.do" method="post">
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
												<td width="70" align="center">${list[0].rNo}<input
													type="hidden" id="rNo" name="rNo" value="${list[0].rNo}"></td>
												<th width="100">작성자</th>
												<td width="150" align="center">${list[0].rWriter}</td>
												<th width="100">작성일자</th>
												<td width="150" align="center">${list[0].rDate}</td>
												<th width="100">조회수</th>
												<td width="70" align="center">${list[0].rHit}</td>
											</tr>
											<tr>
												<th width="100">제목</th>
												<td colspan="7"><input type="text" id="rTitle"
													name="rTitle" size="100" required="required"
													value="${list[0].rTitle}"></td>
											</tr>
											<tr>
												<th width="100">내용</th>
												<td colspan="7"><textarea rows="10" cols="100"
														id="rContent" name="rContent" required="required">${list[0].rContent}</textarea></td>
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
					onclick="location.href='reviewList.do'">목록</button>
			</div>
		</form>
	</div>
	<br>
	<br>
</body>
</html>