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
					 <a href="calendar.do?command=new_calendar&button=year_minus&year=${calendar_map.year}&month=${calendar_map.month}" >◁</a> <!-- 1년 전으로 -->
					 <a href="calendar.do?command=new_calendar&button=month_minus&year=${calendar_map.year}&month=${calendar_map.month}">◀</a> <!-- 1달 전으로 -->
					 
					 <span class="y">${calendar_map.year }</span>년
					 <span class="m">${calendar_map.month}</span>월
					 
					 <a href="calendar.do?command=new_calendar&button=month_plus&year=${calendar_map.year}&month=${calendar_map.month}">▶</a> <!-- 1달 뒤로 -->
					 <a href="calendar.do?command=new_calendar&button=year_plus&year=${calendar_map.year}&month=${calendar_map.month}">▷</a> <!-- 1년 뒤로 -->
					 
					 <input type="button" value="이번달" onclick="location.href='calendar.do?command=calendar'">
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
								<a class="countView" href="calendar.do?command=calendar_list&year=${calendar_map.year}&month=${calendar_map.month}&date=${i }" style="color: blue">
									${i }
								</a>
								<a href="calendar.do?command=cal_issue_insert">
									<img alt="" src="${pageContext.request.contextPath }/assets/css/images/pen.png" style="width: 10px; height: 10px;"/>
								</a>
							</c:when>
							<c:when test="${(calendar_map.day_of_week-1+i) % 7 eq 1 }">
								<a class="countView" href="calendar.do?command=calendar_list&year=${calendar_map.year}&month=${calendar_map.month}&date=${i }" style="color: red">
									${i }
								</a>
								<a href="calendar.do?command=cal_issue_insert">
									<img alt="" src="${pageContext.request.contextPath }/assets/css/images/pen.png" style="width: 10px; height: 10px;"/>
								</a>
							</c:when>
							<c:otherwise>
								<a class="countView" href="calendar.do?command=calendar_list&year=${calendar_map.year}&month=${calendar_map.month}&date=${i }" style="color: black">
									${i }
								</a>
								<a href="calendar.do?command=cal_issue_insert">
									<img alt="" src="${pageContext.request.contextPath }/assets/css/images/pen.png" style="width: 10px; height: 10px;"/>
								</a>
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
	
	<%@ include file= "../project_sidebar.jsp"%>
	
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
</body>
</html>