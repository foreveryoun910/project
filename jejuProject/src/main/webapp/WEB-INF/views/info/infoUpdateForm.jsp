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
		<form id="frm" name="frm" action="infoUpdate.do" method="post">
			<div class="container">
				<!-- Page Heading -->
				<br> <br>
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
												<th width="100">말머리</th>
												<td width="100"><select id="iSubject" name="iSubject">
														<option selected>${list[0].iSubject}</option>
														<option value="맛집">맛집</option>
														<option value="숙소">숙소</option>
														<option value="렌터카">렌터카</option>
												</select></td>
												<th width="100">No.</th>
												<td width="70" align="center">${list[0].iNo}<input
													type="hidden" id="iNo" name="iNo" value="${list[0].iNo}"></td>
												<th width="100">작성자</th>
												<td width="150" align="center">${list[0].iWriter}</td>
												<th width="100">작성일자</th>
												<td width="150" align="center">${list[0].iDate}</td>
												<th width="100">조회수</th>
												<td width="70" align="center">${list[0].iHit}</td>
											</tr>
											<tr>
												<th width="100">제목</th>
												<td colspan="9"><input type="text" id="iTitle"
													name="iTitle" size="115" required="required"
													value="${list[0].iTitle}"></td>
											</tr>
											<tr>
												<th width="100">내용</th>
												<td colspan="9"><textarea rows="10" cols="115"
														id="iContent" name="iContent" required="required">${list[0].iContent}</textarea></td>
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
				<button type="button" class="btn btn-success" onclick="location.href='infoList.do'">목록</button>
			</div>
		</form>
	</div>
	<br>
	<br>
</body>
</html>