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

public class wannabe_invited_prj {

	public static void want_invite(String login_nick, String prj_user, String prj_name, String email, int prj_num,
			int login_num) {

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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			message.setSubject("[Toy] 프로젝트명 : " + prj_name + " 가입 신청서");

			message.setContent("<style type='text/css'>" + 
					"	.img{" + 
					"		position: relative;" +
					"		width: 1000px;" +
					"		height: auto;" +
					"	}" + 
					"</style>" + 
					"<div class='img'>" + 
					"	<img id='img' src='https://data.ac-illust.com/data/thumbnails/78/787dfb0895f05c90d167579a04bd32e3_t.jpeg'>" + 
					"</div>" + 
					"<div class='text'>" + 
					"			<div class='text01'>" + 
					"				<table style='width: 740px'>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: 30pt;'>프로젝트 참여 신청서</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-size: medium;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: large;'><b style='color: #FED259;'>"+login_nick+"</b>님이 <b style='color: #2BC4A8;'>"+prj_user+"</b>님의 프로젝트인&nbsp;<b style='color: #C976E3;'>"+prj_name+"</b>에 참가하길 소망합니다.</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: large;'><b style='color: #FED259;'>"+login_nick+"</b>님이 참여하길 원하신다면 <a href='http://localhost:8787/TOY_Semiproject/invite.do?command=insert_user&prj_num="+prj_num+"&user_num="+login_num+"' style='color: #79AFFA; text-decoration: none;'><b>여기</b></a>를 눌러주세요</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + 
					"					</tr>" + 
					"				</table>" + 
					"			</div>" +
					"</div>",
					"text/html; charset=UTF-8");

			Transport.send(message);
			System.out.println("메시지보냄. 확인바람");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
