$(function () {

    //+++++++++++++++++++++++++++++++++++++++
    //프로젝트 입장

    $(".prj_in").on("click", function () {
        var prj_num = $(this).children(".prj_num").val()
        location.href = "project.do?command=project_board&prj_num=" + prj_num
    })

    //프로젝트 생성 버튼
    $("#prj_plus").on("click", function () {
        location.href = "http://localhost:8787/TOY_Semiproject/project/project_new.jsp"
    })


    //+++++++++++++++++++++++++++++++++++++++
})