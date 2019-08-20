<%@page import="com.toy.home.dto.user_info_dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="../../assets/css/main.css" />
<style type="text/css">
	#user_info_table input {
		display: inline;
	}
	
	#user_info_table span {
		width: 5em;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/member_info.js"></script>
</head>
<% 
	user_info_dto dto = (user_info_dto)request.getSession().getAttribute("user_info_dto");
	String email = dto.getUser_email();
	String email1 = email.substring(0, email.indexOf("@"));
	String email2 = email.substring(email.lastIndexOf("@")+1);
%>

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
				<form method="post" action="${pageContext.request.contextPath}/login.do">
					<header>
						<h3>회원정보 설정</h3>
					</header>
					<input type="hidden" name="command" value="update_user_info">
					<input type="hidden" class="text" name="id" value="${user_info_dto.user_id }" />
					<table id="user_info_table">
						<tr>
							<th>이름</th>
							<td>${user_info_dto.user_name }</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>
							<input type="text" name="nickname" value="${user_info_dto.user_nickname }">
							<input type="button" name="btn_nickcheck" value="중복확인" onclick="nick_check()"/>
							<div id="nick_confirm"></div>
							</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>${user_info_dto.user_id }</td>
						</tr>
						<tr>
							<th style="vertical-align: middle;">비밀번호</th>
							<td>
								<ul>
									<li>
										<label for="now_pw">
											<span>현재 비밀번호 : </span><input type="password" id="now_pw" name="now_pw" placeholder="현재 비밀번호를 입력해주세요.">
										</label>
									</li>
									<li>
										<label for="new_pw">
											<span>새 비밀번호 : </span><input type="password" id="new_pw" name="new_pw" placeholder="변경할 비밀번호를 입력해주세요.">
										</label>
									</li>
									<li>
										<label for="new_pw_chk">
											<span>새 비밀번호 확인 : </span><input type="password" id="new_pw_chk" name="new_pw_chk" placeholder="다시 한 번 입력해주세요.">
											<input type="button" id="pw_change_btn" value="수정하기" onclick="pw_change()">
										</label>
										<div id="pw_success" style="color: green;">비밀번호가 일치합니다.</div>
										<div id="pw_fail" style="color: red;">비밀번호가 일치하지 않습니다.</div>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<th style="vertical-align: middle;">이메일</th>
							<td>
								<input type="text" id="email1" name="email1" value="<%=email1 %>">
								@
								<input type="text" id="email2" name="email2" value="<%=email2 %>">
								<select id="select_email" name="select_email">
									<option value="1" selected>직접 입력</option>
									<option value="naver.com">naver.com</option>
									<option value="daum.net">daum.net</option>
									<option value="hotmail.com">hotmail.com</option>
									<option value="nate.com">nate.com</option>
									<option value="yahoo.co.kr">yahoo.co.kr</option>
									<option value="paran.com">paran.com</option>
									<option value="empas.com">empas.com</option>
									<option value="dreamwiz.com">dreamwiz.com</option>
									<option value="freechal.com">freechal.com</option>
									<option value="lycos.co.kr">lycos.co.kr</option>
									<option value="korea.com">korea.com</option>
									<option value="gmail.com">gmail.com</option>
									<option value="hanmir.com">hanmir.com</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;">
								<input type="submit" value="수정하기" >
								<input type="button" value="회원탈퇴" onclick="withdraw()">
							</td>
						</tr>
					</table>
				</form>
			</section>

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
					<c:choose>
						 <c:when test="${empty user_info_dto }">
							<li><a href="home/member/member_login.jsp">로그인</a></li>	
						 </c:when>
						 <c:otherwise>
							<li><a href="${pageContext.request.contextPath}/login.do?command=logout">로그아웃</a></li>	
						 </c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${empty user_info_dto }">
							<li><a href="home/member/registry.jsp">회원가입</a></li>
						</c:when>					
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/login.do?command=mypage&mypage_access_pw=${test }">마이페이지</a></li>
						</c:otherwise>
					</c:choose>
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
	<script src="../../assets/js/main.js"></script>

</body>

</html>