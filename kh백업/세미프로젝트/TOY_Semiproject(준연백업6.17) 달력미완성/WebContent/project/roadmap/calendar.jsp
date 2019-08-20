<%@page import="com.toy.project.dao.calendar_dao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>
<%@page import="com.toy.project.dao.calendar_daoimpl"%>
<%@page import="com.toy.project.dto.calendar_dto"%>
<%@page import="com.toy.util.calendar_util"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#calendar{
		border-collapse: collapse;
		border: 1px solid gray;
	}
	
	#calendar th{
		width: 80px;
		border: 1px solid gray;
	}
	
	#calendar td{
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	
	a{
		text-decoration: none;
	}
	
	.clist > p {
		font-size: 5px;
		margin: 1px;
		background-color: skyblue;
	}
	
	.cPreview{
		position: absolute;
		top: -30px;
		left: 10px;
		background-color: skyblue;
		width: 40px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		border-radius: 40px 40px 40px 1px;
	}
</style>

<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body>
	<div id="content">
			<table id="calendar">
				<caption>
					 <a id="year_minus">◁</a> <!-- 1년 전으로 -->
					 <a id="month_minus">◀</a> <!-- 1달 전으로 -->
					 
					 <span class="y">${calendar_map.year }</span>년
					 <span class="m">${calendar_map.month}</span>월
					 
					 <a id="month_plus">▶</a> <!-- 1달 뒤로 -->
					 <a id="year_plus">▷</a> <!-- 1년 뒤로 -->
				</caption>
				<tr>
					<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
				</tr>
				<tr>
					<c:forEach begin="1" end="${calendar_map.day_of_week-1 }">
						<td></td>
					</c:forEach>
					<c:forEach var="i" begin="1" end="${calendar_map.last_day }">
						<td>
						<c:choose>
							<c:when test="${(calendar_map.day_of_week-1+i) % 7 eq 0 }">
								<a style="color: blue">${i }</a>
							</c:when>
							<c:when test="${(calendar_map.day_of_week-1+i) % 7 eq 1 }">
								<a style="color: red">${i }</a>
							</c:when>
							<c:otherwise>
								<a style="color: black">${i }</a>
							</c:otherwise>
						</c:choose>
							<div class="clist">
							
							</div>
						</td>
						<c:if test="${(calendar_map.day_of_week-1+i) % 7 eq 0 }">
							<tr></tr>
						</c:if>
					</c:forEach>
					<c:forEach begin="${calendar_map.end_day_of_week }" end="6">
							<td></td>
					</c:forEach>
				</tr>
			</table>
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
	<!-- <div id="commubar" class="prj_bar">
		Logo
		<h1 id="logo">
			<a href="#">채팅</a>
		</h1>

		<div id="main">
			<div id="chat">
				채팅 메시지 영역
			</div>
			<div>
				<input type="text" id="test" placeholder="메시지를 입력해주세요..">
				<button onclick="send()">전송</button>
			</div>
		</div>
	</div>
 -->
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