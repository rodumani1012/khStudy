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
	//클릭한 화살표에 따라 연, 월을 바꾸는 ajax
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
//				$('.y').html(year);
//				$('.m').html(month);
				
				var table = $("<table id='calendar'>");
				var caption = $("<caption>"
						+ "<a id='year_minus'>◁</a>"
						+ "<a id='month_minus'>◀</a>"
						+ "<span class='y'>"+year+"</span>년"
						+ "<span class='m'>"+month+"</span>월"
						+ "<a id='month_plus'>▶</a>"
						+ "<a id='year_plus'>▷</a>"
						+ "</caption>");
				table.append(caption); // 상단 화살표 부분 생성
				
				var tr = $("<tr>"); // 내용 담을 tr태그 생성
				
				var week = $("<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>");
				tr.append(week); // 월화수목금토일 생성
				
				var tr2 = $("<tr>"); // 날짜 담을 tr태그
				var temp = 0; // 엔터를 위한 변수
				
				for (var i = 1; i < day_of_week; i++) {
					var td1 = $("<td></td>");
					tr2.append(td1); // 시작일 앞부분에 공백 생성
					temp++;
				}
				for(var i = 1; i < last_day + 1; i++ ) {
					var td2 = $("<td><a href='calendar.do?command=callist&year="+year+"&month="+month+"&date="+i+"'>"+i+"</a></td>");
					
					if(temp % 7 == 0) {
						var enter = $("<tr></tr>");
						tr2.append(enter); // 일주일마다 엔터
						temp = 0;
					}
					
					tr2.append(td2); // 1,2,3,4...31일까지 칸에 생성
					temp++;
				}
				for(var i = end_day_of_week; i < 7; i++) {
					var td3 = $("<td></td>");
					tr2.append(td3); // 마지막 일 뒷부분 공백 생성
				}
				
				table.append(tr);
				table.append(tr2);
				$("#content").html(table);
			},
			error:function(){
				alert("서버 통신 실패");
			}
		});
	});
});


	