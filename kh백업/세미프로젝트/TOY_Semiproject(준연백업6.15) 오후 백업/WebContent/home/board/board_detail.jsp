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
				<section class="box recent-posts">
					<header>
						<h3>작성글 보기</h3>
					</header>
					<table>
						<tbody>
							<tr>
								<th>번호</th>
								<td>${normal_board_dto.normal_num }</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td>${normal_board_dto.normal_date_create }</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${normal_board_dto.user_nickname }</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${normal_board_dto.normal_title }</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>${normal_board_dto.normal_content }</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td>
									<c:if test="${user_info_dto.user_num eq normal_board_dto.user_num }">
										<input type="button" class="small" value="수정"
											onclick="location.href='home.do?command=board_updateform&normal_num=${normal_board_dto.normal_num}'">
										<input type="button" class="small" value="삭제"
											onclick="location.href='home.do?command=board_delete&normal_num=${normal_board_dto.normal_num}&normal_category=${normal_board_dto.normal_category }'">
									</c:if>


									<input type="button" class="small" value="목록"
										onclick="location.href='home.do?command=board_list&normal_category=${normal_board_dto.normal_category}'">
								</td>
							</tr>
						</tfoot>


					</table>

					<table>
						<tr>
							<th colspan="2">
								<h3>댓글</h3>
							</th>
						</tr>
						<c:forEach items="${comment_board_dto }" var="item">
							<form action="home.do" onsubmit="comment_chk(${empty user_info_dto.user_num})">
								<input type="hidden" name="command" value="comment_comment">
								<input type="hidden" name="comment_num" value="${item.comment_num}">
								<input type="hidden" name="normal_num" value="${normal_board_dto.normal_num}">
								<tr>
									<th>
										<c:forEach begin="1" end="${item.comment_titletab }">
											RE:
										</c:forEach>
										${item.user_nickname }
									</th>
									<td>${item.comment_content }</td>
									<td>
										<a class="comment">&gt;&gt;답글</a>
										<textarea name="comment_comment" id="" cols="10" rows="3"
											style="display: none"></textarea>
										<input type="submit" value="작성" class="small" style="display: none">
										<c:if test="${user_info_dto.user_num eq item.user_num}">
											<input type="button" class="small" value="삭제"
												onclick="location.href='home.do?command=comment_delete&comment_num=${item.comment_num}&normal_num=${normal_board_dto.normal_num}'">
										</c:if>
									</td>
								</tr>
							</form>
						</c:forEach>
					</table>


					<form action="home.do">
						<input type="hidden" name="command" value="comment_insert">
						<input type="hidden" name="normal_num" value="${normal_board_dto.normal_num}">
						<table>
							<tr>
								<th colspan="2">
									<h3>댓글쓰기</h3>
								</th>
							</tr>
							<tr>
								<th>nickname</th>
								<td>${user_info_dto.user_nickname}</td>
							</tr>
							<tr>
								<th>content</th>
								<td><textarea name="comment_content" cols="30" rows="10"></textarea></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" class="small" value="댓글쓰기"></td>
							</tr>
						</table>
					</form>
				</section>
			</article>

			<!-- Pagination -->
			<div class="pagination">
				<!--<a href="#" class="button previous">Previous Page</a>-->
				<div class="pages">
					<a href="#" class="active">1</a> <a href="#">2</a> <a href="#">3</a>
					<a href="#">4</a> <span>&hellip;</span> <a href="#">20</a>
				</div>
				<a href="#" class="button next">Next Page</a>
			</div>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp" %>
	
	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">

	</script>
	<script src="assets/js/main.js?ver=1"></script>
	<script type="text/javascript">
		function comment_chk(bool) {
			if (bool) {
				alert("로그인을 해주세요")
				return false
			} else {
				return true
			}
		}
	</script>

</body>

</html>