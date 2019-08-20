<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

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
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a>
		<span class="title"><a href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<article class="box post post-excerpt">
				<!--
									Note: Titles and subtitles will wrap automatically when necessary, so don't worry
									if they get too long. You can also remove the <p> entirely if you don't
									need a subtitle.
								-->
				<section class="box recent-posts">
					<header>
						<h3>자유게시판</h3>
						<h3>${user_info_dto.user_id }</h3>
						<h3>${user_info_dto.user_num }</h3>
					</header>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
					</ul>
				</section>
			</article>

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>프로젝트</h3>
					</header>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
					</ul>
				</section>
			</article>

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>인원모집</h3>
					</header>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
					</ul>
				</section>
			</article>

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>질문게시판</h3>
					</header>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
					</ul>
				</section>
			</article>

			<!-- Pagination -->
			<div class="pagination">
				<!--<a href="#" class="button previous">Previous Page</a>-->
				<div class="pages">
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<span>&hellip;</span>
					<a href="#">20</a>
				</div>
				<a href="#" class="button next">Next Page</a>
			</div>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="sidebar.jsp" %>
	

	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">
	</script>
	<script src="assets/js/main.js"></script>

</body>

</html>

