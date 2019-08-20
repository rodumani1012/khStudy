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
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a
			href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>글 작성</h3>
					</header>

					<form action="../../home.do" method="get" onsubmit="se2()">
						<input type="hidden" name="command" value="board_insert" /> <input
							type="hidden" name="user_num" value="${user_info_dto.user_num }" />
						<input type="hidden" name="normal_category"
							value="<%=request.getParameter("normal_category")%>" />
						<table>
							<thead>
								<tr>
									<th>작성자</th>
									<td><input type="text" name="user_nickname"
										value="${user_info_dto.user_nickname }" readonly="readonly" /></td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input type="text" name="normal_title"></td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea rows="10" cols="60" id="ir1"
											name="normal_content"></textarea></td>
								</tr>
							</thead>
							<tbody>

							</tbody>

							<tfoot>
								<tr>
									<td><input type="submit" class="small" value="작성" /> 
									<input type="button" class="small" value="취소" onclick="location.href='../../home.do?command=board_list'">
									</td>
								</tr>
							</tfoot>
						</table>

					</form>
					<!-- 	<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
					</ul>
			 -->
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
				<!-- <input type="text" class="text" name="ID" placeholder="ID" />
				<input type="text" class="text" name="PASSWORD" placeholder="PASSWORD" /> -->
			</form>
		</section>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li class="current"><a href="#">프로젝트</a></li>
				<li><a href="home.do?command=board_list&normal_category=FREE">자유게시판</a></li>
				<li><a href="home.do?command=board_list&normal_category=CREW">인원모집</a></li>
				<li><a href="home.do?command=board_list&normal_category=QA">질문게시판</a></li>
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
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js">
		
	</script>
	<script src="../../assets/js/main.js"></script>
	<!-- Smart Editor2 -->
	<script type="text/javascript"
		src="../../se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "ir1",
			sSkinURI : "../../se2/SmartEditor2Skin.html",
			htParams : {
				bUseVerticalResizer : false,
				bUseModeChanger : false
			},
		fOnAppLoad : function () {
			oEditors.getById["ir1"].exec("PASTE_HTML", [""])
		},
		fCreator : "createSEditor2"
		})

		function se2() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", [])
		}
	</script>
	<!-- 페이징 -----------------------------https://okky.kr/article/282819
----검색기능 ----https://all-record.tistory.com/129
int page = 22;

int countList = 10;

int countPage = 10;


int totalCount = 255;


int totalPage = totalCount / countList;


if (totalCount % countList > 0) {

    totalPage++;

}



if (totalPage < page) {

    page = totalPage;

}



int startPage = ((page - 1) / 10) * 10 + 1;

int endPage = startPage + countPage - 1;



if (endPage > totalPage) {

    endPage = totalPage;

}



if (startPage > 1) {

    System.out.print("<a href=\"?page=1\">처음</a>");

}



if (page > 1) {

    System.out.println("<a href=\"?page=" + (page - 1)  + "\">이전</a>");

}



for (int iCount = startPage; iCount <= endPage; iCount++) {

    if (iCount == page) {

        System.out.print(" <b>" + iCount + "</b>");

    } else {

        System.out.print(" " + iCount + " ");

    }

}


if (page < totalPage) {
    
    System.out.println("<a href=\"?page=" + (page + 1)  + "\">다음</a>");

}



if (endPage < totalPage) {

    System.out.print("<a href=\"?page=" + totalPage + "\">끝</a>");

}

-->
</body>

</html>