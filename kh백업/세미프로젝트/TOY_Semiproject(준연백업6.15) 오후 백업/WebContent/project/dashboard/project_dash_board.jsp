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
<title>Striped by HTML5 UP</title>
<meta charset="utf-8" />
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" /> -->
<link rel="stylesheet" href="assets/css/main.css" />
<!-- <link rel="stylesheet" href="assets/chat/static/css/index.css"> -->

</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a
			href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">

		<header class="subhead">
			<h2>Project name${prj_num_session}</h2>
			<button class="toggle2 small">commubar</button>
			<input type="text" id="board_title">
			<button class="dash_board small"
				onclick="board_new(${project_board[0].prj_num})">보드 생성</button>
		</header>

		<div id="backboard">
			<c:forEach items="${project_board }" var="item">
				<article class="box post post-excerpt backboard">
					<!-- Text -->
					<section class="box text-style1">
						<div class="inner connected">
							<p id="${item.board_num}">
								<strong>${item.board_title } </strong>
							</p>
							<c:forEach items="${issue_list }" var="issue_item">
								<c:if test="${item.board_num eq issue_item.board_num }">
									<div class="inner issue">
										<p>${issue_item.issue_title }</p>
										<p>${issue_item.issue_num }</p>
									</div>
								</c:if>
							</c:forEach>
							<input type="button" class="tiny" value="+"
								onclick="issue_new(${item.prj_num}, ${item.board_num} )">
						</div>
					</section>
				</article>
			</c:forEach>
		</div>
	</div>

	<!-- Sidebar -->
	<div id="sidebar">
		<!-- Logo -->
		<h1 id="logo">
			<a href="#">STRIPED</a>
		</h1>

		<!-- Search -->
		<section class="box search">
			<form method="post" action="#">
				<ul>
					<li><a href="#">로그인</a></li>
					<li><a href="#">회원가입</a></li>
				</ul>
			</form>
		</section>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li class="current"><a href="#">대쉬보드</a></li>
				<li><a href="${pageContext.request.contextPath }/calendar.do?command=calendar">로드맵</a></li>
				<li><a href="#">파일</a></li>
				<li><a href="#">회의</a></li>
				<li><a href="#">히스토리</a></li>
			</ul>
		</nav>

		<!-- Text -->

		<!-- Recent Posts -->
		<section class="box recent-posts">
			<header>
				<h2>Recent Posts</h2>
			</header>
			<ul>
				<li><a href="#">Lorem ipsum dolor</a></li>
				<li><a href="#">Feugiat nisl aliquam</a></li>
				<li><a href="#">Sed dolore magna</a></li>
				<li><a href="#">Malesuada commodo</a></li>
				<li><a href="#">Ipsum metus nullam</a></li>
			</ul>
		</section>

		<!-- Recent Comments -->
		<section class="box recent-comments">
			<header>
				<h2>Recent Comments</h2>
			</header>
			<ul>
				<li>case on <a href="#">Lorem ipsum dolor</a></li>
				<li>molly on <a href="#">Sed dolore magna</a></li>
				<li>case on <a href="#">Sed dolore magna</a></li>
			</ul>
		</section>

		<!-- Copyright -->
		<ul id="copyright">
			<li>&copy; TOY.</li>
			<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul>

		<div>asdf</div>

	</div>

	<!-- Commubar -->
	<div id="commubar" class="prj_bar">
		<!-- Logo -->
		<h1 id="logo">
			<a href="#">채팅</a>
		</h1>

		<div id="main">
			<div id="chat">
				<!-- 채팅 메시지 영역 -->
			</div>
			<div>
				<input type="text" id="test" placeholder="메시지를 입력해주세요..">
				<button onclick="send()">전송</button>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="assets/js/prj.js?ver=1"></script>
	<script src="http://localhost:8000/socket.io/socket.io.js"></script>
	<script src="assets/chat/static/js/index.js?ver=1"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/calendar.js"></script>
</body>

</html>