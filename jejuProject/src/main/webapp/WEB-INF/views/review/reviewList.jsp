<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function getRecord(n) {
			frm.rNo.value = n;
			frm.submit();
		}
	</script>
</head>
<body>
	<div class="container">
		<!-- Page Heading -->
		<div>
			<!-- DataTales Example -->
			<div class="card shadow mb-4">
				<div align="center">
					<h1 class="h3 mb-2 text-gray-800">제주도 여행후기</h1>
					<br>
					<div class="row" style="float: none; margin: 100 auto;">
						<div class="col-lg-10" style="float: none; margin: 100 auto;">
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered table-hover" id="dataTable"
										width="100%" cellspacing="0">
										<thead>
											<tr>
												<th width="70">No.</th>
												<th width="250">제목</th>
												<th width="90">작성자</th>
												<th width="90">작성일자</th>
												<th width="90">조회수</th>
												<th width="60">추천</th>
											</tr>
										</thead>

										<tbody>
											<c:forEach var="review" items="${list}">
												<tr onmouseover="this.style.background='yellow'"
													onmouseout="this.style.background='white'"
													onclick="getRecord(${review.rNo})">
													<td align="center">${review.rNo}</td>
													<td>${review.rTitle}&nbsp;&nbsp;<span><font
															color="#fc0384">[${review.rAno}]</font></span></td>
													<td align="center">${review.rWriter}</td>
													<td align="center">${review.rDate}</td>
													<td align="center">${review.rHit}</td>
													<td align="center">${review.rLike}</td>
												</tr>
											</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div>
						<button type="button" class="btn btn-success"
							onclick="location.href='home.do'">HOME</button>
						<c:if test="${id != null}">
						&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-success"
							onclick="location.href='reviewInsertForm.do'">글쓰기</button>
						</c:if>	
					</div>
				</div>
			</div>
			<br><br>
			<form id="frm" name="frm" action="reviewSelect.do" method="post">
				<input type="hidden" id="rNo" name="rNo">
			</form>
		</div>
	</div>

	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>

</body>
</html>