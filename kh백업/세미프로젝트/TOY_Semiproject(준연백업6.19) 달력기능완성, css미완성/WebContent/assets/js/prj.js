$(function () {

    $("body").prop("class", "sidebar-visible commubar-visible")

    var url = "project/meeting/meeting_room.jsp";
    var title = "myframe";
    var prop = "top=200px,left=600px,width=500px,height=500px";
    //open("팝업으로 실행할 파일 주소","팝업이 열릴 창 이름"[,"옵션"])
    window.open(url, title, prop);

    // Sidebar .prj_bar
    $('.toggle').click(function () {
        var emp = "";
        $("body").prop("class", function (i, val) {
            if (val === "") {
                emp = "sidebar-visible"
            } else if (val.includes("commubar-visible")) {
                if (val.includes("sidebar-visible")) {
                    emp = "commubar-visible"
                } else {
                    emp = "sidebar-visible commubar-visible"
                }
            }
            $("body").prop("class", emp);
        })
    })

    // Commubar .prj_bar
    $('.toggle2').click(function () {
        var emp = "";
        $("body").prop("class", function (i, val) {
            if (val === "") {
                emp = "commubar-visible"
            } else if (val.includes("sidebar-visible")) {
                if (val.includes("commubar-visible")) {
                    emp = "sidebar-visible"
                } else {
                    emp = "sidebar-visible commubar-visible"
                }
            }
            $("body").prop("class", emp);
        })
    })

    // board_title_update
    $('.board_title').on('dblclick', function () {
        var before_title = $(this).find('strong').text()
        var board_num = $(this).prop('id')
        $('strong').css('display', 'inline')
        $('.emp_title').remove()
        $(this)
            .append(
                `<input type="text" value="${before_title}" class="emp_title" onkeypress="board_update($(this).val(), ${board_num})">`)
        $(this).find('strong').css('display', 'none')


    })

    // board_title_update 초기화
    $(document).on('click', function (e) {
        if (!$(e.target).is('.emp_title')) {
            $('strong').css('display', 'inline')
            $('.emp_title').remove()
        }
    })
})

// board_update
function board_update(to_title, board_num) {
    if (event.keyCode == 13) {
        $.ajax({
            url: `project.do?command=board_update&board_num=${board_num}&to_title=${to_title}`,
            method: 'post',
            success: function () {
                $('.board_title').find('input').after(
                    `<strong>${to_title} </strong>`)
                $('.board_title').find('input').remove()
            },
            error: function () {
                alert('error')
            }
        })
    }
}

// 대쉬보드
// board_new
function board_new(num) {
    var title = $('#board_title').val().trim()
    var prj_num = "prj_num=" + num;

    if (title == null || title == "") {
        alert("보드의 이름을 입력해주세요")
    } else {
        $.ajax({
            url: "project.do?command=board_new&title=" + title + "&"
                + prj_num,
            success: function () {
                location.href = `project.do?command=project_board&prj_num=${num}`
            },
            error: function () {
                alert("실패")
            }
        })
    }
}