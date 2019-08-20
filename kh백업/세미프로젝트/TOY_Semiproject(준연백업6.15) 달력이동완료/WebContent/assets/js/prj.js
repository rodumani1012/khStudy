$(function () {

    $("body").prop("class", "sidebar-visible commubar-visible")


    // Sidebar .prj_bar
    $('.toggle').on("click", function () {
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
    $('.toggle2').on("click", function () {
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
})

// 대쉬보드 : 보드 생성
function board_new(num) {
    var title = $('#board_title').val()
    var prj_num = "prj_num=" + num
    $.ajax({
        url: "project.do?command=board_new&title=" + title + "&" + prj_num,
        success: function () {
            $('#backboard').append("<article class='box post post-excerpt backboard'><section class='box text-style1'><div class='inner'><p><strong>" + title + "</strong></p><div class='inner issue'><p> Issue name</p ></div ></div ></section ></article > ")
        },
        error: function () {
            alert("실패")
        }
    })
}
