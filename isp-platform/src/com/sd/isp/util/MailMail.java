package com.sd.isp.service.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
	private SimpleMailMessage simpleMailMessage;

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String to, String dear, String content) {

	
	   SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
	   message.setFrom("prometeo875@gmail.com");
	   message.setTo(to);

	   message.setText(String.format(
			simpleMailMessage.getText(), dear, content));

	   mailSender.send(message);

	}
}