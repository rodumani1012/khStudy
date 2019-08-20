$(function(){
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
				$('.y').html(year);
				$('.m').html(month);
			},
			error:function(){
				alert("서버 통신 실패");
			}
		});
	});
	
	
});
	