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
<script src="assets/js/issue.js?ver=1"></script>

<head>

	<title>Striped by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/main.css" />
</head>

<body class="is-preload">

	
	<!-- Content -->
<!-- 	<div id="content"> -->
		<div class="inner">

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>이슈 보기</h3>
					</header>
					<table>
						
						<thead>
							<tr>
								<th>중요도</th>
								<td>${prj_issue_dto.issue_require } </td>
							</tr>
							
							<tr>
								<th>이슈 제목</th>
								<td>${prj_issue_dto.issue_title }</td>
							</tr>
							<tr>
								<th>이슈 내용</th>
								<td>${prj_issue_dto.issue_content }</td>
							</tr>
							<tr>
								<th>요구인원</th>
								<td>${prj_issue_dto.issue_require }</td>
							</tr>
							<tr>
								<th>책임자</th>
								<td>${prj_issue_dto.issue_charge }</td>
							</tr>
							<tr>
								<th>마감기한</th>
								<td>${prj_issue_dto.issue_deadline }</td>
							</tr>
							
						<tfoot>
							<tr>
								<td>
									<c:if test="${user_info_dto.user_num eq normal_board_dto.user_num }">
										<input type="button" class="small" value="수정"
											onclick="location.href='home.do?command=issue_updateform&normal_num=${prj_issue_dto.issue_num}'">
										<input type="button" class="small" value="삭제"
											onclick="location.href='home.do?command=issue_delete&issue_num=${prj_issue_dto.issue_num}'">
									</c:if>


									<input type="button" class="small" value="목록"
										onclick="location.href='home.do?command=project_board'">
								</td>
							</tr>
						</tfoot>


					</table>

					
	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">

	</script>
	<script src="assets/js/main.js?ver=1"></script>


</body>

</html>