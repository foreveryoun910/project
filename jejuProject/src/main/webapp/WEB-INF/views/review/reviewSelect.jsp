<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h1 class="h3 mb-2 text-gray-800">제주도 여행후기</h1>
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
											<td width="70" align="center">${list[0].rNo}</td>
											<th width="100">작성자</th>
											<td width="150" align="center">${list[0].rWriter}</td>
											<th width="100">작성일자</th>
											<td width="150" align="center">${list[0].rDate}</td>
											<th width="100">조회수</th>
											<td width="70" align="center">${list[0].rHit}</td>
										</tr>
										<tr>
											<th width="100">제목</th>
											<td colspan="7">${list[0].rTitle}</td>
										</tr>
										<tr>
											<th width="100">내용</th>
											<td colspan="7"><textarea rows="10" cols="100">${list[0].rContent}</textarea></td>
										</tr>


									</tbody>

								</table>

					<div>
						<button type="button" class="btn btn-success"
							onclick="location.href='reviewList.do'">목록</button>
						<c:choose>
						<c:when test="${list[0].rWriter == sessionScope.nickname}">
							&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-success"
								onclick="location.href='reviewUpdateForm.do?rNo=${list[0].rNo}'">수정</button>
							&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-success"
								onclick="location.href='reviewDelete.do?rNo=${list[0].rNo}'">삭제</button>
						</c:when>
						<c:when test="${author eq 'ADMIN'}">
							&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-success"
								onclick="location.href='reviewUpdateForm.do?rNo=${list[0].rNo}'">수정</button>
							&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-success"
								onclick="location.href='reviewDelete.do?rNo=${list[0].rNo}'">삭제</button>
						</c:when>
						</c:choose>
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
															<c:if test="${list[0].rAno != 0}">
																<c:forEach var="review" items="${list}">
																	<tr>
																		<!-- 댓글번호.. -->
																		<input type="hidden" id="rcNo" name="rcNo"
																			value="${review.rcNo}">
																		<!-- 아이디,작성날짜 -->
																		<td width="150">
																			<div>${review.rcName}<br> <font size="2"
																					color="lightgray">${review.rcDate}</font>
																			</div>
																		</td>
																		<!-- 댓글내용 -->
																		<td width="540">
																			<div class="text_wrapper">${review.rcContent}</div>
																		</td>
																		<td align="center">
																			<!-- 댓글 작성자만 수정,삭제 가능하도록 //////////// 나중에.. --> <!-- <a href="reviewCommentUpdate.do">[수정]</a> -->
																			<button type="submit" class="btn btn-danger" 
																				onclick="location.href='reviewCommentDelete.do?rcNo=${review.rcNo}'">댓글삭제</button>
																			<!-- <c:if test="${review.rcName == review.rWriter == sessionScope.id}">
																				 </c:if> -->
																		</td>
																	</tr>
																</c:forEach>
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
					<form id="reviewCommentInsertForm" action="reviewCommentInsert.do">
						<!-- 로그인 했을 경우만 댓글 작성 가능 -->
						<table>
							<c:if test="${sessionScope.id != null}">
								<tr bgcolor="#F5F5F5" align="center">

									<input type="hidden" id="rNo" name="rNo" value="${list[0].rNo}">
									<input type="hidden" id="rcName" name="rcName"
										value="${sessionScope.nickname}">
									<!-- 닉네임 -->
									<td width="150">
										<div>${sessionScope.nickname}</div>
									</td>
									<!-- 댓글 작성 -->
									<td width="530">
										<div>
											<textarea id="rcContent" name="rcContent" rows="4" cols="70"></textarea>
										</div>
									</td>
									<!-- 댓글 등록 버튼 -->
									<td width="100" align="center">
										<div id="btn" style="text-align: center;">
											<p>
												<button type="submit" class="btn btn-success">댓글등록</button>
											</p>
										</div>
										<div>
											<input type="hidden" id="rNo" name="rNo"
												value="${list[0].rNo}"> <input type="hidden"
												id="rWriter" name="rWriter" value="${list[0].rWriter}">
											<input type="hidden" id="rDate" name="rDate"
												value="${list[0].rDate}"> <input type="hidden"
												id="rHit" name="rHit" value="${list[0].rHit}"> <input
												type="hidden" id="rTitle" name="rTitle"
												value="${list[0].rTitle}"> <input type="hidden"
												id="rContent" name="rContent" value="${list[0].rContent}">
											<input type="hidden" id="rcDate" name="rcDate"
												value="${list[0].rcDate}">
										</div>
									</td>
								</tr>
							</c:if>
						</table>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>