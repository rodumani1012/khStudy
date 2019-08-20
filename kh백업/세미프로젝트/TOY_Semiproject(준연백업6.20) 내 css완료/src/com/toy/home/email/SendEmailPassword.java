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

public class SendEmailPassword {
	
	public static String getRandomPassword() {
		char[] charSet = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int arr = 0;
		StringBuffer sb = new StringBuffer();
		for (int i=0 ; i<6 ; i++) {
			arr = (int)(charSet.length * Math.random());
			sb.append(charSet[arr]);
		}
		
		return sb.toString();
	}
//	
//	private static class senderAccount extends javax.mail.Authenticator {
//		public PasswordAuthentication getPasswordAuthentication() {
//			return new PasswordAuthentication("simpolor", "password");
//		}
//	}
	
	public static void sendPassward(String email, String randompass) {
		
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
		
			message.setSubject("[Toy] 인증번호 입니다.");
		
			message.setContent("<style type='text/css'>" + 
					"	.img{" + 
					"		position: relative;" +
					"		width: 1000px;" +
					"		height: auto;" +
					"	}" + 
					"</style>" + 
					"<div class='img'>" + 
					"	<img id='img' src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBMVK1Rvmz8vMuh9BvEbGPApRlWqtPWS6lq6iU1hBtbLB6cw6_'>" + 
					"</div>" + 
					"<div class='text'>" + 
					"			<div class='text01'>" + 
					"				<table style='width: 740px'>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: 30pt;'>이메일 인증번호</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-size: medium;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td colspan='2' width='740px' style='font-family: 맑은 고딕; font-size: large;'>인증번호&nbsp;[<b style='color: #FE0873;'>"+randompass+"</b>]를 창에 정확히 입력해 주세요:)</td>" + 
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
