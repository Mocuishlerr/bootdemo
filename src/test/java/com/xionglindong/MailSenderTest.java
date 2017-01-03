package com.xionglindong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootDemoApplication.class)
public class MailSenderTest {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void sendSimpleMail() throws Exception{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xld1992@163.com");
		message.setTo("ldx@innotek-co.com");
		message.setSubject("主题：测试");
		message.setText("测试邮件内容");
		
		javaMailSender.send(message);
	}

}
