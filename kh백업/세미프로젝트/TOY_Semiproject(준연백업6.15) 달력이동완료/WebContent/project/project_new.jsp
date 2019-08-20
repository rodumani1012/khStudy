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
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post" action="../project.do">
					<header>
						<h3>프로젝트 생성</h3>
					</header>
					<input type="hidden" value="project_new" name="command">
					<input type="hidden" value="${user_info_dto.user_num}" name="user_num">
					<input type="text" class="text" name="prj_name" required placeholder="프로젝트 이름" />
					<input type="text" class="text" name="prj_invite1" placeholder="초대할 사람 아이디" />
					<input type="text" class="text" name="prj_invite2" placeholder="초대할 사람 이메일" />
					<!-- <input type="text" name="" id="" placeholder="주소"> -->
					<input type="submit" value="프로젝트 생성" name="" id="">
				</form>
			</section>

		</div>
	</div>
	
	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp" %>


</body>

</html>