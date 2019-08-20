<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="../../assets/css/main.css?ver=1" />
</head>
<body>
	<!-- http://192.168.10.139:8787/TOY_Semiproject/project/meeting/meeting_room.jsp -->
	<!-- Commubar -->
	<div id="commubar" class="prj_bar">
		<!-- Logo -->
		<h1 id="logo">
			<a href="#">채팅 </a>
		</h1>

		<form action="" onclick="user_list(${prj_num_session})">
			<select name="접속자" id="join_user">
				<option id="sel_placeholder" disabled selected>접속자</option>
			</select>
		</form>

		<div id="main">
			<div id="chat">
				<!-- 채팅 메시지 영역 -->
			</div>
			<div>
				<input type="text" id="test" placeholder="메시지를 입력해주세요..">
				<button onclick="send()">전송</button>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var project_num = ${ prj_num_session }
		var user_nickname = '${user_info_dto.user_nickname}'
	</script>
	<script src="http://192.168.10.139:8000/socket.io/socket.io.js"></script>
	<script src="../../assets/commu/static/js/chat.js?ver=1"></script>
	<script src="../../assets/js/prj.js?ver=1"></script>

</body>
</html>