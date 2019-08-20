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

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/calendar.js"></script>
<link rel="stylesheet" href="assets/css/main.css" />
<script src="assets/js/main.js"></script>
</head>
<% 
	Map<String, Integer> map = (Map<String, Integer>)request.getAttribute("map");
%>
<body>

	<table id="calendar">
		<caption>
			 <a id="year_minus">◁</a> <!-- 1년 전으로 -->
			 <a id="month_minus">◀</a> <!-- 1달 전으로 -->
			 
			 <span class="y">${map.year}</span>년
			 <span class="m">${map.month}</span>월
			 
			 <a id="month_plus">▶</a> <!-- 1달 뒤로 -->
			 <a id="year_plus">▷</a> <!-- 1년 뒤로 -->
		</caption>
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
		<tr>
		<c:forEach begin="1" end="${map.day_of_week-1 }">
			<td></td>
		</c:forEach>
		<c:forEach var="i" begin="1" end="${map.last_day }">
			<td>
				<a>${i }</a>
				<a>
					<img src="${pageContext.request.contextPath }/assets/css/images/pen.png" style="width: 10px; height: 10px;"/>
				</a>
			</td>
			<c:if test="${(map.day_of_week-1+i) % 7 eq 0 }">
				<tr></tr>
			</c:if>
		</c:forEach>
		<c:forEach begin="${map.end_day_of_week }" end="6">
				<td></td>
		</c:forEach>
		</tr>
	</table>
	
	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp" %>
</body>
</html>