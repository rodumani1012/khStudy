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
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
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
			<h2>Project name${prj_num_session}</h2>
		</header>

		<div>
			<article class="box post post-excerpt">

			</article>
		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file= "../project_sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript">
		var project_num = ${ prj_num_session }
		var user_nickname = '${user_info_dto.user_nickname}'
	</script>
	<script src="http://192.168.10.139:8000/socket.io/socket.io.js"></script>
	<script src="assets/js/prj.js?ver=1"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script type="text/javascript" src="assets/commu/static/js/jquery.event.drag-2.0.js"></script>
	<script type="text/javascript" src="assets/commu/static/js/scripts.js"></script>


</body>

</html>