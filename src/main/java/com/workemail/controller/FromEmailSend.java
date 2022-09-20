//package com.workemail.controller;
//
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FromEmailSend {
//
//	@Value("${from.email.address}")
//	private String fromEmailAddress;
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	@Async
//	@PostMapping("/sendEmail")
//	public String sendEmail() {
//		try {
////			new AmazonW
//			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
//			messageHelper.setFrom(new InternetAddress(fromEmailAddress));
//			messageHelper.setTo("34akramash@gmail.com");
//			System.out.println(mimeMessage.getFrom());
//			System.out.println();
//			System.out.println(mimeMessage.getFrom());
//			messageHelper.setSubject("papi papi papi chulo chulo chulo papai papi!!!");
//			messageHelper.setText("panipat", true);
//			javaMailSender.send(mimeMessage);
//			return "email send successfully";
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return "email not send successfully";
//	}
//
//}
package com.workemail.controller;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FromEmailSend {

	@Value("${from.email.address}")
	private String fromEmailAddress;

	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	@PostMapping("/sendEmail")
	public String sendEmail() {
		try {
//			new AmazonW
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(new InternetAddress(fromEmailAddress));
			System.out.println(mimeMessage.getFrom());
			messageHelper.setTo("34akramash@gmail.com");
			messageHelper.setSubject("papi papi papi chulo chulo chulo papai papi!!!");
			messageHelper.setText("bangami bangami bangami", true);
			javaMailSender.send(mimeMessage);
			return "email send successfully";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "email not send successfully";
	}

}

