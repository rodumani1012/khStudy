//issue 생성화면 넘기는 ajax
function issue_new(prj_number, board_number) {

	var issue_title = "issue_title=" + $('#issue_title').val();

		
	$.ajax({
		url : "project/dashboard/issue_insert.jsp", 
		method : "GET",
		dataType:"text",
		success:function(data){
			
		
			$('#content').html(data)
				
		},
		error:function(){
			alert("실패")
		}
	
	})
}

//issue_insert
function issue_insert(prj_num, board_num){
	
//	alert($('input[name=issue_charge]').val())
//	alert($('select[name=issue_priority]').val())
//	alert($('input[name=user_nickname]').val())
//	alert($('textarea#issue_content').val())
//	alert($('select[name=issue_require]').val())
//	alert($('input[name=issue_charge]').val())
//	alert($('input[name=issue_deadline').val())

	var issue_data={
			
			issue_priority:($('select[name=issue_priority]').val()),
			// user_info_dto = (user_info_dto)request.getSession().getAttribue("user_info_dto")
			//user_nickname:($('input[name=user_nickname]').val()),
			issue_title:($('input[name=issue_title]').val()),
			issue_content:($('textarea#issue_content').val()),
			issue_require:($('select[name=issue_require]').val()),
			issue_charge:($('input[name=issue_charge]').val()),
			issue_deadline:($('input[name=issue_deadline]').val()),
			prj_num:prj_num,
			board_num:board_num
			
			
	}
	
	var sendData = JSON.stringify(issue_data)
	
	alert(sendData)
	
	$.ajax({
		
		url : "project.do?command=issue_insert&prj_num"+prj_num+"&board_num="+board_num,
		method : "post",
		data : {"obj":sendData},
		success:function(){
			
			$('#content').load('project/dashboard/issue_detail.jsp')
			
		},
		error:function(){
			alert("실패")
		}
	
	})	
	
	
}
/*
function issue_detail(issue_num){
$(".inner issue").on("click", function () {
	
	$.ajax({
		url : "project.do?command=issue_detail&issue_num"+issue_num,
		method : "post",
		success:function(){
			$('#content').load('project/dashboard/issue_detail.jsp')		
		},
		error:function(){
			alert("실패")
		}
	})
	
})

}
*/	