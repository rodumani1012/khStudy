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
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" /> -->
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body class="is-preload">


	<!-- Content -->

	<div id="issue_content">
		<div class="inner">

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>이슈 작성</h3>
						
					</header>

					<table>
						<thead>
							<tr>
								<th>중요도</th>
								<td><select name="issue_priority" id="issuepriority">
										<option value="VERY_HIGH">VERY HIGH</option>
										<option value="HIGH">HIGH</option>
										<option value="MEDIUM" selected="selected">MEDIUM</option>
										<option value="LOW">LOW</option>
										<option value="VERY_LOW">VERY LOW</option>
								</select></td>
							</tr>
							
							<tr>
								<th>이슈 제목</th>
								<td><input type="text" name="issue_title"></td>
							</tr>
							<tr>
								<th>이슈 내용</th>
								<td><textarea rows="10" cols="60" id="issue_content"
										name="issue_content"></textarea></td>
							</tr>
							<tr>
								<th>요구인원</th>
								<td><select name="issue_require">
										<option value="1">1명</option>
										<option value="2">2명</option>
										<option value="3">3명</option>
										<option value="4">4명</option>
										<option value="5">5명</option>
										<option value="6">6명</option>
										<option value="7">7명</option>
										<option value="8">8명</option>
										<option value="9">9명</option>
										<option value="10">10명</option>
								</select></td>
							</tr>
							<tr>
								<th>책임자</th>
								<td><input type="text" name="issue_charge"></td>
							</tr>
							<tr>
								<th>마감기한</th>
								<td><input type="text" name="issue_deadline"></td>
							</tr>
						


						</thead>
						<tbody>

						</tbody>

						<tfoot>
							<tr>
								<td><input type="button" class="small" value="작성"
									onclick="issue_insert(${prj_num_session}, 1)" /> <input
									type="button" class="small" value="취소"></td>
							</tr>
						</tfoot>
					</table>
				</section>
			</article>
		</div>
	</div>



	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="assets/js/prj.js"></script>
	<script src="assets/js/issue.js?ver=1"></script>
</body>

</html>