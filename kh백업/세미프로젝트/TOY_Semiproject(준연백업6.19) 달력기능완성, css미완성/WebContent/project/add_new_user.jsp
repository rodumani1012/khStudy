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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/main.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/new_add_user.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body class="is-preload">

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post" action="project.do">
					<header>
						<h3>초대하기</h3>
					</header>
					<input type="hidden" value="new_add_user" name="command">
					<input type="hidden" value="${prj_num_session}" name="prj_num"/>
					<input type="hidden" value="${user_info_dto.user_num}" name="user_num"/>
					<input type="text" class="text" name="user_nickname" value="${user_info_dto.user_nickname }" readonly="readonly" />
					
					<input type="text" class="text" name="prj_invite_nick01" placeholder="초대할 사람 닉네임" onchange="nick_check01()" />
					<div id="nick_confirm01"></div>
					<input type="text" class="text" name="prj_invite_nick02" placeholder="초대할 사람 닉네임" onchange="nick_check02()" />
					<div id="nick_confirm02"></div>
					<input type="text" class="text" name="prj_invite_nick03" placeholder="초대할 사람 닉네임" onchange="nick_check03()" />
					<div id="nick_confirm03"></div>
					<input type="text" class="text" name="prj_invite_nick04" placeholder="초대할 사람 닉네임" onchange="nick_check04()" />
					<div id="nick_confirm04"></div>
					<input type="text" class="text" name="prj_invite_nick05" placeholder="초대할 사람 닉네임" onchange="nick_check05()" />
					<div id="nick_confirm05"></div>
					<input type="submit" value="초대하기">
				</form>
			</section>

		</div>

	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp" %>


</body>

</html>