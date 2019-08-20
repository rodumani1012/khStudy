	function pick_me(){
		var userno = $("input[name=user_num]").val();
		var prjno = $("input[name=prj_num]").val();
		$.ajax({
			url:"../TOY_Semiproject/project.do?command=pick&user_num="+userno+"&prj_num="+prjno,
			type:"POST",
			success:function(res){
				if($.trim(res) == userno){
					alert("해당 프로젝트에 이미 참여하고 있습니다.");
				}else{
					alert("해당 프로젝트 담당자님에게 메일을 보냅니다.");
					location.href="../TOY_Semiproject/project.do?command=pick_email&user_num="+userno+"&prj_num="+prjno;
				}
			},
			error:function(){
				
			}
		});
	}
	
	function pick_me_fail(){																		//
		alert("로그인 후 신청해 주세요!");															//
//		var prjno = $("input[name=prj_num]").val();													//
//		location.href="../TOY_Semiproject/project.do?command=project_show&prj_num="+prjno;			//
	}