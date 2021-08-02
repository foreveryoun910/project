<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<br> <br>
		<div align="center">
			<form id="frm" name="frm" action="infoInsert.do" method="post">
				<div class="card shadow mb-4">
					<div class="row" style="float: none; margin: 100 auto;">
						<div class="col-lg-9" style="float: none; margin: 100 auto;">
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<tbody>
											<tr>
												<th width="80">말머리</th>
												<td><select id="iSubject" name="iSubject">
														<option selected>말머리</option>
														<option value="맛집">맛집</option>
														<option value="숙소">숙소</option>
														<option value="렌터카">렌터카</option>
												</select></td>
												<th>작성자</th>
												<td width="150"><input type="text" id="iWriter"
													name="iWriter" size="35" value="${sessionScope.nickname}" required="required"></td>
												<th>작성일자</th>
												<td><input type="date" id="iDate" name="iDate"
													size="40"></td>
											</tr>
											<tr>
												<th>제목</th>
												<td colspan="5"><input type="text" id="iTitle"
													name="iTitle" size="100" required="required"></td>
											</tr>
											<tr>
												<th>내용</th>
												<td colspan="5"><textarea rows="10" cols="100"
														id="iContent" name="iContent" required="required"
														placeholder="내용을 입력하세요."></textarea></td>
											</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div>
					<button type="submit" class="btn btn-success">등록</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-success"
						onclick="location.href='infoList.do'">목록</button>
				</div>
			</form>
		</div>
	</div>
	<br>
	<br>
</body>
</html>