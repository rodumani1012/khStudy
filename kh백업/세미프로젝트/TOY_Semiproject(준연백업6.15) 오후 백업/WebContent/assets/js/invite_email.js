	var prjname = false;

	function prj_name_check(){
		var prj_name = $("input[name=prj_name]").val();
		var user_num = $("input[name=user_num]").val();
		if(prj_name != null || prj_name == ""){
			$.ajax({
				url:"../invite.do?command=prj_name_chk&user_num="+user_num+"&prj_name="+prj_name,
				type:"POST",
				success:function(res){
					if(res == null || res == ""){
						alert("사용할 수 없는 프로젝트명 입니다.");
					}else{
						alert("사용가능한 프로젝트명 입니다.");
						prjname = true;
					}
				},
				error:function(){
					
				}
			});
		}
	}

	function nick_check(){
		var user_nick = $("input[name=prj_invite_nick]").val();
		if(user_nick != null || user_nick != ""){
			$.ajax({
				url:"../invite.do?command=nick_chk&nickname="+user_nick,
				type:"POST",
				success:function(res){
					if(res != user_nick){
						alert("존재하지 않는 닉네임입니다.");
					}else{
						alert(user_nick+"님을 초대하시겠습니까?");
						$("div[id=nick_confirm]").html(user_nick+'님에게 초대를 보냅니다.');
					}
				},
				error:function(){
					
				}
			});
		}
	}
	
	function formsubmit(){
		var prj_name = $("input[name=prj_name]").val();
		var user_nick = $("input[name=prj_invite_nick]").val();
		if(prj_name == "" || prj_name == null){
			alert("프로젝트명을 만들어 주세요!");
			return false;
		}else{
			if(user_nick == null || user_nick == ""){
				user_nick == " ";
				if(prjname == false){
					alert("프로젝트명을 다시 설정해 주세요!")
					return false;
				}
				return true;
			}
		}
	}