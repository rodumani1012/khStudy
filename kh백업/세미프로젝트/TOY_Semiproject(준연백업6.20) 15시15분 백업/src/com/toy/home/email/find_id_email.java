package com.toy.home.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class find_id_email {
	
	public static void send_find_email(String email, String user_id) {
		
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
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
			message.setSubject("[Toy] 아이디를 찾았습니다");
		
			message.setContent("<style type='text/css'>" + 
					"	.img{" + 
					"		position: relative;" +
					"		width: 1000px;" +
					"		height: auto;" +
					"	}" + 
					"</style>" + 
					"<div class='img'>" + 
					"	<img id='img' src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0DuHLdSbLrK8o1XmAIuIsR81csOm_KPov6jpa1MW2JtZqeaIY'>" + 
					"</div>" + 
					"<div class='text'>" + 
					"			<div class='text01'>" + 
					"				<table style='width: 740px'>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: 30pt;'>아이디찾기</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-size: medium;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: large;'>회원님의 아이디는&nbsp;<b style='color: #FE0873;'>"+user_id+"</b>입니다.</td>" + 
					"					</tr>" +
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: large;'>비밀번호도 모르시겠다면<a href='http://192.168.10.139:8787/TOY_Semiproject/home/member/find_id_pw.jsp' style='color: #79AFFA; text-decoration: none;'><b>여기</b></a>를 눌러주세요 </td>" + 
					"					</tr>" +
					"				</table>" + 
					"			</div>",
					"text/html; charset=UTF-8");
		
			Transport.send(message);
			System.out.println("메시지보냄. 확인바람");
	
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
