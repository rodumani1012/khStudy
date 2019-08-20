$(function () {
	// issue 생성
	$(document).on('click', '.issue_new', function () {
		var new_div = $('.in').parent().parent()
		new_div.next().toggle()
		new_div.remove()
		var button_new = $(this)
		var emp = "<div class='inner temp'>"
			+ "<p><textarea class='in' cols='10' rows='5'></textarea></p>"
			+ "<input type='button' class='tiny new_go' value='만들기'></input>"
			+ "<input type='button' class='tiny new_stop' value='취소'></input>"
			+ "</div >"

		$(this).before(emp)
		$(this).toggle()
		$(".in").focus()

		$('.new_stop').on('click', function () {
			button_new.toggle()
			$(this).parent().remove()
		})

		$('.new_go')
			.on(
				'click',
				function () {
					if ($('.in').val().trim() == '' || $('.in').val().trim() == null) {
						alert('제목을 입력해주세요')
					} else {
						var button_go = $(this)
						var prj_num = project_num
						var board_num = $(this).parent()
							.parent().parent()
							.find('p').eq(0).prop('id')
						var issue_title = $('.in').val()
						$
							.ajax({
								url: "project.do?command=issue_new&prj_num="
									+ prj_num
									+ "&board_num="
									+ board_num
									+ "&issue_title="
									+ issue_title,
								method: "post",
								success: function () {

									location.href = "project.do?command=project_board&prj_num=" + prj_num

									// button_new.toggle()
									// $('.in')
									// .parent()
									// .text(
									// issue_title)
									// $('.inner.temp').prop('class', 'inner
									// issue')
									// $('.in').remove()
									// $('.new_go')
									// .remove()
									// $('.new_stop')
									// .remove()
								},
								error: function () {
									alert('error')
								}
							})
					}
				})
	})

	// issue_detail
	$(document).on('click', '.inner.issue', function () {
		var issue_num = $(this).prop('id')
		bring_issue(issue_num)
		bring_reply(issue_num)
	})

	$('#detail_back').on('click', function () {

		location.href = "project.do?command=project_board&prj_num=" + project_num
		// $('.layer').css('display', 'none')
		// $('#pop').css('display', 'none')
		// $('option').prop('disabled', 'disabled')
		// $('.2click').prop('readonly', true)
		// $('.is_update').remove()
	})

	$('#charger').on('dblclick', function () {
		$.ajax({
			url: "project.do?command=bring_user&prj_num=" + project_num,
			method: "post",
			dataType: "json",
			success: function (data) {
				data.forEach(i => {
					$('#charger').empty()
					var emp;
					data.forEach(i => {
						emp += `<option value="${i["USER_NICKNAME"]}">${i["USER_NICKNAME"]}</option>`
					});
					$('#charger').append(emp)
				});
			},
			error: function () {
				alert("error")
			}
		})
	})

	$(document).on('dblclick', '.2click', function () {
		$('option').prop('disabled', 'disabled')
		$('.2click').prop('readonly', true)
		$('.is_update').remove()
		$(this).prop('readonly', false)
		$(this).children('option').removeProp('disabled')
		$(this).parent().append("<button class='tiny is_update'>수정</button>")
		$(this).parent().append("<button class='tiny is_update'>취소</button>")

		$('.is_update').on('click', function () {
			var text = $(this).text()
			var issue_num = $('table').prop('id')
			var input_tag = $(this).prev()
			var column = $(this).prev().prop('id')
			var content = $(this).prev().val()
			var startline = $(this).prev().prev().val()

			var map = {
				issue_num: issue_num,
				column: column,
				content: content
			}

			if (startline != null) {
				map.startline = startline
			}

			var sendData = JSON.stringify(map)
			if (text === '수정') {
				$.ajax({
					url: "project.do?command=issue_update",
					data: {
						issue_update: sendData
					},
					method: "post",
					success: function () {
						input_tag.prop('readonly', true)
						$('.is_update').remove()
					},
					error: function () {
						alert('error')
					}
				})
			} else if (text === '취소') {
				$('.2click').prop('readonly', true)
				$('.is_update').remove()
				$('option').prop('disabled', 'disabled')
				bring_issue(issue_num)
			}
		})
	})

	$('#issue_del').on('click', function () {
		var bool = confirm("삭제하시겠습니까?")
		var issue_num = $('table').prop('id')
		if (bool) {
			$.ajax({
				url: "project.do?command=issue_del&issue_num=" + issue_num,
				method: "post",
				success: function () {
					location.href = "project.do?command=project_board&prj_num=" + project_num
					// $('#' + issue_num).remove()
					// $('.layer').css('display', 'none')
					// $('#pop').css('display', 'none')
				},
				error: function () {
					alert('error')
				}
			})
		}
	})


	$('.reply').on('click', function () {
		if ($(this).val() == '+') {
			var issue_num = $('table').prop('id')
			var reply_content = $('#reply_content').val().trim()
			var user_nickname = $(this).parent().prev().text()

			if (reply_content == null || reply_content == "") {
				alert('댓글을 입력해주세요')
			} else {
				$.ajax({
					url: `project.do?command=reply_insert&reply_content=${reply_content}&issue_num=${issue_num}&user_nickname=${user_nickname}`,
					method: 'post',
					success: function () {
						$('#reply_in').children().remove()
						bring_reply(issue_num)
						var emp = `<tr>
												<th>${user_nickname}</th>
												<td>
													<textarea id="reply_content" cols="70" rows="2" placeholder="댓글 추가..."></textarea>
													<input type="button" class="tiny reply" value="+">
													</td>
												</tr>`
						$('#reply_in').append(emp)
					},
					error: function () {
						alert("error")
					}
				})
			}
		}
	})

	// backboardSortable
	sort()

})

function bring_issue(issue_num) {
	$.ajax({
		url: "project.do?command=issue_detail&issue_num=" + issue_num,
		method: "post",
		dataType: "json",
		success: function (data) {
			$('.layer').css('display', 'block')
			$('#pop').css('display', 'block')
			$('#priority').val(data["ISSUE_PRIORITY"])
			$('#title').val(data["ISSUE_TITLE"])
			$('#text').val(data["ISSUE_CONTENT"])
			$('#require').val(data["ISSUE_REQUIRE"])
			$('#charger').empty()
			if (data["ISSUE_CHARGE"] == null) {
				$('#charger').append(`<option value="${data["ISSUE_CHARGE"]}" selected disabled>책임자를 지정해주세요</option>`)
			} else {
				$('#charger').append(`<option value="${data["ISSUE_CHARGE"]}" selected disabled>${data["ISSUE_CHARGE"]}</option>`)
			}
			$('table').prop('id', data["ISSUE_NUM"])

			var startline = date_form(data["ISSUE_DATE_UPDATE"])
			var deadline = date_form(data["ISSUE_DEADLINE"])

			$('#startline').val(startline)
			$('#deadline').val(deadline)
		},
		error: function () {
			alert('issue_detail_error')
		}
	})
}

function bring_reply(issue_num) {
	$.ajax({
		url: `project.do?command=bring_reply&issue_num=${issue_num}`,
		method: 'post',
		dataType: 'json',
		success: function (data) {
			data.forEach(i => {
				var content = i["REPLY_CONTENT"]
				var nickname = i["USER_NICKNAME"]

				var emp = `<tr>
										<th>${nickname}</th>
										<td>${content}</td>
									</tr>`

				$('#reply_in').prepend(emp)
			});
		},
		error: function () {
			alert('error')
		}
	})
}

function sort() {

	$(".inner").sortable({
		connectWith: ".connected",
		items: '>div',
		tolerance: 'pointer',
		revert: 'invalid',
		forceHelperSize: true,
		stop: function (event, ui) {
			var issue_num = ui.item.prop('id')
			var board_num = ui.item.siblings('p').eq(0).prop('id')
			$.ajax({
				url: `project.do?command=issue_move&issue_num=${issue_num}&board_num=${board_num}`,
				method: 'post',
				success: function () {
				},
				error: function () {
					alert('shit')
				}
			})
		}
	})

	var before_board
	var after_board
	var before_num
	$("#backboard").sortable({
		tolerance: 'pointer',
		revert: 'invalid',
		forceHelperSize: true,
		start: function (event, ui) {
			before_board = ui.item.index()
		},
		update: function (event, ui) {
			after_board = ui.item.index()
			before_num = ui.item.find('p').eq(0).prop('id')
			$.ajax({
				url: "project.do?command=board_move&after_board=" + after_board + "&before_num=" + before_num + "&before_board=" + before_board,
				success: function () {
				},
				error: function () {
					alert("보드 이동 중에 오류가 발생했습니다.")
				}
			})
		}
	})
}

function date_form(date) {
	// Jun 18, 2019 11: 36: 04 AM

	var array = date.split(' ')

	var month = array[0]
	var day = array[1].substring(0, 2)
	var year = array[2]

	switch (month) {
		case 'Jan':
			month = '01'
			break;
		case 'Feb':
			month = '02'
			break;
		case 'Mar':
			month = '03'
			break;
		case 'Apr':
			month = '04'
			break;
		case 'May':
			month = '05'
			break;
		case 'Jun':
			month = '06'
			break;
		case 'Jul':
			month = '07'
			break;
		case 'Aug':
			month = '08'
			break;
		case 'Sep':
			month = '09'
			break;
		case 'Oct':
			month = '10'
			break;
		case 'Nov':
			month = '11'
			break;
		case 'Dec':
			month = '12'
			break;
	}

	day = two_char(day)

	return `${year}-${month}-${day}`

}

function two_char(str) {

	if (str.length == 1) {
		return `0${str}`
	} else {
		return str
	}

}

