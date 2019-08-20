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

		String host = "smtp.naver.com";
		final String user = "toy_project";
		final String password = "1q2wtoy3e4r";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			project_biz biz = new project_bizimpl();

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			message.setSubject("[Toy] 프로젝트명 :" + prj_name + " 에 참여를 원합니다.");

			message.setContent(login_nick + "님께서 " + prj_user + "님의 [" + prj_name + "] 프로젝트에 참여하고 싶어합니다."
					+ "<br/>참여를 승인하시고자 하면 <a href='http://localhost:8787/TOY_Semiproject/invite.do?command=insert_user&prj_num="
					+ prj_num + "&user_num=" + login_num + "'>여기</a>를 눌러주세요", "text/html; charset=UTF-8");

			Transport.send(message);
			System.out.println("메시지보냄. 확인바람");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
