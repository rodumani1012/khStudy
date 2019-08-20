<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.toy.project.dto.calendar_dto"%>
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

	<title>Striped by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/main.css" />
</head>
<%
	calendar_dto dto = (calendar_dto)request.getAttribute("dto");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String issue_date_update = sdf.format(dto.getIssue_date_update());
	String issue_deadline = sdf.format(dto.getIssue_deadline());
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
			<article class="box post post-excerpt">
				<section class="box recent-posts" style="width:900px;">
					<header>
						<h3>이슈 상세 보기</h3>
					</header>

					<form action="${pageContext.request.contextPath}/calendar.do?command=issue_update" method="post">
					<input type="hidden" name="origin_board_num" id="board_num" value="${dto.board_num }">
					<input type="hidden" name="issue_num" id="issue_num" value="${dto.issue_num }">
					<input type="hidden" id="year" value="${year }">
					<input type="hidden" id="month" value="${month }">
					<input type="hidden" id="date" value="${date }">
					<table>
						<tr>
							<th>카테고리 선택</th>
							<td>
								 <select name="category">
								 	<c:forEach items="${prj_board_list }" var="prj_board">
								 		<option value="${prj_board.board_title }" <c:if test="${prj_board.board_num eq dto.board_num}">selected</c:if>>${prj_board.board_title }</option>
								 	</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th>중요도</th>
							<td><select name="issue_priority" id="issuepriority">
									<option value="VERYHIGH" <c:if test="${dto.issue_priority eq 'VERY_HIGH'}">selected</c:if>>VERY HIGH</option>
									<option value="HIGH" <c:if test="${dto.issue_priority eq 'HIGH'}">selected</c:if>>HIGH</option>
									<option value="MEDIUM" <c:if test="${dto.issue_priority eq 'MEDIUM'}">selected</c:if>>MEDIUM</option>
									<option value="LOW" <c:if test="${dto.issue_priority eq 'LOW'}">selected</c:if>>LOW</option>
									<option value="VERYLOW" <c:if test="${dto.issue_priority eq 'VERY_LOW'}">selected</c:if>>VERY LOW</option>
							</select></td>
						</tr>
						<tr>
							<th>이슈 제목</th>
							<td><input type="text" name="issue_title" value="${dto.issue_title }" required="required"></td>
						</tr>
						<tr>
							<th>이슈 내용</th>
							<td><textarea rows="10" cols="60" id="issue_content"
									name="issue_content" required="required">${dto.issue_content }</textarea></td>
						</tr>
						<tr>
							<th>책임자</th>
							<td><input type="text" name="issue_charge" value="${dto.issue_charge }" required="required"></td>
						</tr>
						<tr>
							<th>시작일</th>
							<td><input type="date" name="issue_update" value="<%=issue_date_update %>" required="required"></td>
						</tr>
						<tr>
							<th>마감기한</th>
							<td><input type="date" name="issue_deadline" value="<%=issue_deadline %>" required="required"></td>
						</tr>
						<tr>
							<td colspan="3">
							<input type="submit" class="small" value="수정하기" />
							<input type="reset" class="small" value="리셋">
							<input type="button" class="small" value="취소" onclick="location.href='calendar.do?command=calendar_list&year=${year}&month=${month}&date=${date }'">
							<input type="button" class="small" value="삭제" onclick="issue_delete()">
							</td>
						</tr>
					</table>
				</form>
				</section>
			</article>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file= "../project_sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="assets/js/main.js?ver=1"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/calendar.js"></script>
	
</body>

</html>