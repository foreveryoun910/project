<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<div class="container">
		<br>
		<br>
		<!-- Page Heading -->
		<div align="center">
			<form id="frm" name="frm" action="boardInsert.do" method="post">
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
												<th>작성자</th>
												<td><input type="text" id="bWriter" name="bWriter"
													value="관리자" size="35" readonly="readonly"></td>
												<th>작성일자</th>
												<td><input type="date" id="bDate" name="bDate"
													size="40"></td>
											</tr>

											<tr>
												<th>글 제목</th>
												<td colspan="3"><input type="text" id="bTitle"
													name="bTitle" size="100" required="required"></td>
											</tr>
											<tr>
												<th>글 내용</th>
												<td colspan="3"><textarea rows="10" cols="100"
														id="bContent" name="bContent" required="required"
														placeholder="내용을 입력하세요."></textarea></td>
											</tr>
										</tbody>
									</table>
								</div>
								<br>
								<div>
									<button type="submit" class="btn btn-success">등록</button>
									&nbsp;&nbsp;&nbsp;
									<button type="button" class="btn btn-success"
										onclick="location.href='boardList.do'">목록</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<br>
		<br>
		<!-- /.container -->





		<!-- Page level plugins -->
		<script src="vendor/datatables/jquery.dataTables.min.js"></script>
		<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="js/demo/datatables-demo.js"></script>
</body>
</html>