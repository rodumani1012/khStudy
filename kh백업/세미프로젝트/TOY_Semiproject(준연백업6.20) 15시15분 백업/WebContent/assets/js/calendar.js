function issue_delete() {
	var result = confirm("이슈를 삭제하시겠습니까?");
	var issue_num = $("#issue_num").val();
	var board_num = $("#board_num").val();
	var year = $("#year").val();
	var month = $("#month").val();
	var date = $("#date").val();
	
	if (result) {
		location.href="calendar.do?command=issue_delete&issue_num=" + issue_num + "&board_num=" + board_num + 
		"&year=" + year + "&month=" + month + "&date=" + date;
	}
	
//	location.href='calendar.do?command=issue_delete';
}