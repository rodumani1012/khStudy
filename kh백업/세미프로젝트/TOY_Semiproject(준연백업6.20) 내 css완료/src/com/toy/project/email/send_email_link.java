package com.toy.project.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.toy.project.biz.project_biz;
import com.toy.project.biz.project_bizimpl;

public class send_email_link {
	
	// prj_name : 프로젝트 이름 | prj_num : 프로젝트 번호 | invite_nick : 초대할 분의 닉네임 | invite_email : 초대할 분의 이메일 | prj_user : 프로젝트 생성자 | user_num : 생성자 회원번호
	public static void sendPassward(String prj_name, int prj_num, String invite_nick, String invite_email, String prj_user, int user_num) {
		
		String user = "toyproject0621@gmail.com";
        String password = "1q2wtoy3e4r";

        // SMTP 서버 정보를 설정한다.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", 465); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.ssl.enable", "true"); 
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
	
		try {
			project_biz biz = new project_bizimpl();
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(invite_email));
		
			message.setSubject("[Toy] 초대링크 입니다.");
		
			message.setContent("<style type='text/css'>" + 
					"	.img{" + 
					"		position: relative;" +
					"		width: 1000px;" +
					"		height: auto;" +
					"	}" + 
					"</style>" + 
					"<div class='img'>" + 
					"	<img id='img' src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3SaHFuA__UZP7Bjpiemfh98B05AxNW04MQWgSlIt6NaxqW1ENOQ'>" + 
					"</div>" + 
					"<div class='text'>" + 
					"	<div class='text01'>" + 
					"		<table style='width: 740px'>" + 
					"			<tr>" + 
					"				<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: 28pt;'>초대장이 도착했습니다.</td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td colspan='2' width='740px' style='font-size: medium;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: large;'><b style='color: #F8A99E;'>"+prj_user+"</b>님이 <b style='color: #96E0BD;'>"+prj_name+"</b>&nbsp;프로젝트에 <b style='color: #F8A99E;'>"+invite_nick+"</b>님을 초대하였습니다.</td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: large;'>프로젝트에 참여하고 싶다면 <a href='http://localhost:8787/TOY_Semiproject/invite.do?command=insert_user&prj_num="+prj_num+"&user_num="+biz.bring_num(invite_nick).getUser_num()+"' style='color: #79AFFA; text-decoration: none;'><b>여기</b></a>를 눌러주세요</td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + 
					"			</tr>" + 
					"		</table>" + 
					"	</div>" + 
					"	" + 
					"	<div class='text02'>" + 
					"		<table style='width: 500px'>" + 
					"			<tr>" + 
					"				<td colspan='2' style='font-family: 맑은 고딕; font-size: 20pt;'>프로젝트 정보</td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td width='200px' style='padding-top: 10px; text-align: center; font-family: 맑은 고딕; font-size : 13pt;'>프로젝트명</td>" + 
					"				<td style='text-align: center; padding-top: 10px; font-family: 맑은 고딕; font-size : 13pt;'>"+prj_name+"</td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td width='200px' style='text-align: center; padding-top: 10px; font-family: 맑은 고딕; font-size : 13pt;'>프로젝트 작성자</td>" + 
					"				<td style='text-align: center; padding-top: 10px; font-family: 맑은 고딕; font-size : 13pt;'>"+prj_user+"</td>" + 
					"			</tr>" + 
					"		</table>" + 
					"	</div>" + 
					"</div>",
					"text/html; charset=UTF-8");
		
			Transport.send(message);
			System.out.println("메시지보냄. 확인바람");
	
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
