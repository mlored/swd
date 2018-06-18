package com.sd.isp.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.sd.isp.dto.user.UserDTO;
import com.sun.jersey.api.spring.Autowire;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailMail
{
	@Autowired
	private MailSender mailSender;
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	
	@Value("email.incoming.sms.from.address")
	private String userMail;

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Async
	public void sendMail(String to, String dear, String content) {
	   
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		simpleMailMessage.setFrom(userMail);
		simpleMailMessage.setTo(to);

		 simpleMailMessage.setText(String.format(
				simpleMailMessage.getText(), dear, content));
		
		mailSender.send(simpleMailMessage);
		System.out.println("Email enviado");
	}
}