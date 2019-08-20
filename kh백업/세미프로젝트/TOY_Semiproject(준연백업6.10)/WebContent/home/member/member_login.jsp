<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<style type="text/css">

	#kakao-login-btn > img{
		width: 234.4px;
	}

</style>

</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a
			href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post" action="${pageContext.request.contextPath}/login.do">
					<input type="hidden" value="login_chk" name="command">
					<header>
						<h3>로그인</h3>
					</header>
					<input type="text" class="text" name="id" placeholder="아이디"
						required="required" /> <input type="password" class="text"
						name="pw" placeholder="비밀번호" required="required" /> <input
						type="submit" value="로그인" name="" id="">
				</form>
			</section>
			<hr style="width: 17em">
			<div style="margin-left: 1.3em;">
				<a id="kakao-login-btn"></a>
				<script src="../../assets/js/kakaologin.js"></script>
				<br>
				<div class="fb-login-button" data-width="" data-size="large"
					data-button-type="login_with" data-auto-logout-link="false"
					data-use-continue-as="false" scope="public_profile,email"
					onlogin="checkLoginState();" style="margin-bottom: 0.4em;"></div>
				<script src="../../assets/js/facebooklogin.js"></script>
				<script async defer crossorigin="anonymous"
					src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.3&appId=2443466142555702&autoLogAppEvents=1"></script>
				<br>
				<%@ include file="../member/naverlogin.jsp"%>
			</div>
		</div>
	</div>

	<!-- Sidebar -->
	<div id="sidebar">

		<!-- Logo -->
		<h1 id="logo">
			<a href="${pageContext.request.contextPath}/home.jsp">STRIPED</a>
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
				<li class="current"><a href="#">프로젝트</a></li>
				<li><a href="#">자유게시판</a></li>
				<li><a href="#">인원모집</a></li>
				<li><a href="#">질문게시판</a></li>
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

	</div>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js">
		
	</script>
	<script src="../../assets/js/main.js"></script>

</body>

</html>