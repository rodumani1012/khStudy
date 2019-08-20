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
<html>

<head>
	<title>TOY</title>
	<meta charset="utf-8" />
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" /> -->
	<link rel="stylesheet" href="assets/css/main.css?ver=1" />
	<!-- <link rel="stylesheet" href="assets/chat/static/css/index.css"> -->
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a href="#">TOY</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<header class="subhead">
			<h2>대쉬보드${prj_num_session}</h2>
			<input type="text" id="board_title">
			<button class="dash_board small" onclick="board_new(${project_board[0].prj_num})">보드 생성</button>
			<button
				onclick="location.href='invite.do?command=dash_insert_user&prj_num=${prj_num_session}&user_num=${user_info_dto.user_num}'">초대하기</button>
		</header>

				<div id="backboard">
			<c:forEach items="${project_board }" var="item">
				<article class="box post post-excerpt backboard">
					<!-- Text -->
					<section class="box text-style1">
						<div class="inner connected">
							<p class="board_title" id="${item.board_num}">
								<strong>${item.board_title } </strong>
							</p>
							<c:forEach items="${issue_list }" var="issue_item">
								<c:if test="${item.board_num eq issue_item.board_num }">
									<div class="inner issue" id="${issue_item.issue_num}">
											<p>${issue_item.issue_title }</p> 
										<div class="issue_info_left">
										<c:choose>
											<c:when test="${issue_item.issue_priority eq 'MEDIUM' }">
												<img src="assets/css/images/medium.png" alt="">
											</c:when>
											<c:when test="${issue_item.issue_priority eq 'HIGH' }">
												<img src="assets/css/images/major.png" alt="">
											</c:when>
											<c:when test="${issue_item.issue_priority eq 'VERYHIGH' }">
												<img src="assets/css/images/critical.png" alt="">
											</c:when>
											<c:when test="${issue_item.issue_priority eq 'LOW' }">
												<img src="assets/css/images/low.png" alt="">
											</c:when>
											<c:when test="${issue_item.issue_priority eq 'VERYLOW' }">
												<img src="assets/css/images/blocker.png" alt="">
											</c:when>
										</c:choose>
										</div>
										<div class="issue_info_right">
										<span>${issue_item.issue_charge }</span>
										</div>
									</div>
								</c:if>
							</c:forEach>
							<div class="inner issue" style="display: none"></div>
							<input type="button" class="tiny issue_new" value="+">
						</div>
					</section>
				</article>
			</c:forEach>
		</div>
		<%@ include file="issue_detail.jsp"%>
	</div>

	<!-- Sidebar -->
	<%@ include file= "../project_sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript">
		var project_num = ${ prj_num_session }
		var user_nickname = '${user_info_dto.user_nickname}'
	</script>
	<script src="assets/js/prj.js?ver=1"></script>
	<script src="assets/js/issue.js?ver=1"></script>
</body>

</html>