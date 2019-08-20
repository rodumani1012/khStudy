<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE HTML>
<!--
	Striped by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html lang="ko">

<head>
<title>TOY</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/main.css?ver=1" />
</head>
<script type="text/javascript">
	function PageMove(page, data) {
		location.href = "home.do?command=board_list&normal_category=${normal_category }&page=" + page + "&txt_search=" + $('input#txt_search').val();
	}

</script>


<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a href="#">TOY</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			
					<header class="subhead">
						<h2>인원모집</h2>
					</header>

					<input type="hidden" name="myid" value=${user_info_dto.user_name }>
					<input type="hidden" name="mypw" value=${user_info_dto.user_pw }>

					<h1>급구!</h1>

					<table>

						<thead>

							<tr>
								<th>번호</th>
								<th>작성자</th>
								<th>제목</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>

							<c:choose>
								<c:when test="${empty list }">
									<tr>
										<td class="insert_class">작성된 글이 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${list }" var="dto">

										<c:if test="${dto.normal_premium eq 'Y'}">
											<tr>
												<td>${dto.normal_num }</td>
												<td>${dto.user_nickname }</td>
												<td><a
													href="home.do?command=board_detail&normal_num=${dto.normal_num }">${dto.normal_title
														}</a></td>
												<td>${dto.normal_date_create}</td>
												<td>${dto.normal_count }</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</tbody>
					</table>

					<br>
					<br>
					<h5>일반</h5>
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>작성자</th>
								<th>제목</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty list }">
									<tr>
										<td class="insert_class">작성된 글이 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${list }" var="dto">
										<c:if test="${dto.normal_premium eq 'N'}">
											<tr>
												<td>${dto.normal_num }</td>
												<td>${dto.user_nickname }</td>
												<td><a
													href="home.do?command=board_detail&normal_num=${dto.normal_num }">${dto.normal_title
														}</a></td>
												<td>${dto.normal_date_create }</td>
												<td>${dto.normal_count }</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>

					</table>
					<table>

						<tr>
							<td colspan="2"><input type="text" id="txt_search"
								value="${txt_search }"> <input type="button"
								class="small" value="검색"
								onclick="javascript:PageMove(${paging.pageNo})"> <input
								type="button" class="small" value="글쓰기"
								onclick="location.href='home.do?command=insertform&normal_category=CREW'">
							</td>
						</tr>

					</table>

			



			<!-- Pagination -->
			<div class="pagination">
				<a href="javascript:PageMove(${paging.firstPageNo})"
					class="button previous">&laquo;</a> <a
					href="javascript:PageMove(${paging.prevPageNo})"
					class="button previous">&lt;</a>
				<div class="pages">
					<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNo}">
								<a href="javascript:PageMove(${i})" class="active">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:PageMove(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
				<a href="javascript:PageMove(${paging.nextPageNo})"
					class="button next">&gt;</a> <a
					href="javascript:PageMove(${paging.finalPageNo})"
					class="button next">&raquo;</a>
			</div>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">

	</script>
	<script src="assets/js/main.js"></script>



</body>

</html>