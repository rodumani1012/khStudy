	var email_chk = false;
	var nick_chk = false;
	
	function send_email(){
		var user_email = $("input[name=email]").val();
		if(user_email == null || user_email == ""){
			alert("이메일을 입력해 주세요");								
		}else{
			$.ajax({
				url:"./login.do?command=send_email&email="+user_email,
				type:"POST",
				success:function(res){
					alert("이메일 전송 완료")
					$("input[name=code]").change(function(){
						if($("input[name=code]").val()==res){
							$("div[id=confirm]").html('');
							email_chk = true;
						}else{
							$("div[id=confirm]").html('');
							$("div[id=confirm]").html('인증실패 다시 쓰세요');
							$("div[id=confirm]").val("");
						}
					});
				},
				error:function(){
					
				}
			});
		}
		
	}
	
	function nick_check(){
		var user_nick = $("input[name=nickname]").val();
		if(user_nick == null || user_nick == ""){
			alert("닉네임을 입력하세요");
		}else{
			$.ajax({
				url:"./login.do?command=nick_check&nickname="+user_nick,
				type:"POST",
				success:function(res){
					if(res != user_nick){
						$("div[id=nick_confirm]").html('사용가능한 닉네임 입니다.');
						nick_chk = true;
					}else{
						$("div[id=nick_confirm]").html('이미 사용중인 닉네임 입니다.');
						$("div[id=nick_confirm]").val("");
					}
				},
				error:function(){
					
				}
			});
		}
	}
	
	function formsubmit(){
		if(email_chk == true && nick_chk == true){
			alert("회원가입 완료!");
			return true;
		}
		alert("다시 확인해 주세요!")
		return false;
	}