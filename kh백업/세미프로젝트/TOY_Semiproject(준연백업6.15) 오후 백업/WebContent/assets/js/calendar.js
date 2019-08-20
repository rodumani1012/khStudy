$(function(){
	
	// 로드맵으로 이동하는 ajax
	function go_roadmap() {
		$.ajax({
			type: 'post',
			url: 'calendar.do?command=calendar',
			success:function(){
				alert("달력으로 이동!");
				$('#content').load('project/roadmap/calendar.jsp');
			},
			error:function(){
				alert("서버 통신 실패");
			}
		});
	}
	
	// 클릭한 화살표에 따라 연, 월을 바꾸는 ajax
	$('#year_minus, #month_minus, #year_plus, #month_plus').click(function(){
		var btn = $(this).attr('id');
		var year = $('.y').text();
		var month = $('.m').text();
		$.ajax({
			type: 'post',
			data: { "btn" : btn, "year" : year, "month" : month },
			url:"calendar.do?command=new_calendar", // 보낼 곳	
			dataType: "json",// 받을 데이터 형식
			success:function(msg){
				year = msg.year;
				month = msg.month;
				var day_of_week = msg.day_of_week;
				var last_day = msg.last_day;
				var end_day_of_week = msg.end_day_of_week;
				console.log("dayofweek: " + day_of_week + "  last_day: " + last_day + "  end: " + end_day_of_week);
				$('.y').html(year);
				$('.m').html(month);				
			},
			error:function(){
				alert("서버 통신 실패");
			}
		});
	});
	

	 
});
	