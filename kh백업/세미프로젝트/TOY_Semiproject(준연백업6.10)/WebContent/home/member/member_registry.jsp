<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html>

<head>
	<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer></script>
	<script type="text/javascript" src="../../assets/js/signup.js"></script>
	<title>Striped by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../../assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post" action="${pageContext.request.contextPath}/login.do" onsubmit="return formsubmit();">
					<input type="hidden" name="command" value="regist"/>
					<header>
						<h3>회원가입</h3>
					</header>
					<input type="text" class="text" name="name" placeholder="이름" required />
					<input type="text" class="text" name="id" placeholder="아이디" required />
					<div id="id_confirm"></div>
					<input type="button" id="btn_idcheck" value="중복확인" onclick="id_check()"/><p></p>
					<input type="password" class="text" name="password" placeholder="비밀번호" onchange="pass_check()" required />
					<div id="pass_check"></div>
					<input type="password" class="text" name="password02" placeholder="비밀번호 확인" onchange="pass_confirm()" required />
					<div id="pass_confirm"></div>
					<input type="text" class="text" name="nickname" placeholder="닉네임" required />
					<div id="nick_confirm"></div>
					<input type="button" name="btn_nickcheck" value="중복확인" onclick="nick_check()"/><p></p>
					<input type="text" class="text" name="email" placeholder="이메일" required/>
					<input type="button" id="btn_sendemail" value="인증번호발송" onclick="send_email()"/><p></p>
					<input type="text" class="text" name="code" placeholder="인증번호" required/><div id="confirm"></div>
					<div id="example1"></div>
					<p></p>

					<input type="submit" value="회원가입"/>
				</form>
			</section>

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
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">

	</script>
	<script src="../../assets/js/main.js"></script>

</body>

</html>