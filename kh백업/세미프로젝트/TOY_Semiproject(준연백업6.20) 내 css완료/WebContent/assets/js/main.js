$(function () {

    // 초기화
    $("body").prop("class", "")

    //프로젝트 입장

    $(".prj_in").on("click", function () {
        var prj_num = $(this).children(".prj_num").val()
        location.href = "project.do?command=project_board&prj_num=" + prj_num
    })

    //프로젝트 생성 버튼
    $("#prj_plus").on("click", function () {
        location.href = "http://localhost:8787/TOY_Semiproject/project/project_new.jsp"
    })

    // Sidebar .prj_bar
    $('.toggle').click(function () {
        var emp = "";
        $("body").prop("class", function (i, val) {
            if (val === "") {
                emp = "sidebar-visible"
            }
            $("body").prop("class", emp);
        })
    })

    // 댓글 textarea display
    $(".comment").on("click", function () {
        $(this).siblings().css("display", "block")
    })

    $('#prj_search').on('click', function () {
        var select = $(this).prev().prev().val()
        var keyword = $(this).prev().val()

        if (keyword.trim() == "" || keyword.trim() == null) {
            alert("키워드를 입력해주세요")
        } else {

            $.ajax({
                url: `project.do?command=prj_search&select=${select}&keyword=${keyword}`,
                method: 'post',
                dataType: 'json',

                success: function (data) {
                    $('#search_result').children().remove()

                    data.forEach(i => {
                        var emp = `<article class="box post post-excerpt">
					                    <section class="box text-style1">
                                              <div class="inner prj_show" id=${i["PRJ_NUM"]}>
                                                   <p>
                                                           <strong>${i["PRJ_NAME"]}</strong><br>
                                                          <strong>${i["USER_NICKNAME"]}</strong>
						                            </p>
					                            	</div>
				                        	</section>
			                        	</article>`

                        $('#search_result').append(emp)
                    });

                    $('.prj_show').on('click', function () {
                        var prj_num = $(this).prop('id')
                        location.href = `project.do?command=project_show&prj_num=${prj_num}`
                    })

                },
                error: function () {
                    alert('error')
                }
            })
        }


    })

})