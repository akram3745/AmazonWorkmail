package com.workemail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {

    public Properties mailProperties() {
        Properties props = new Properties();

        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "outlook.mail.us-east-1.awsapps.com");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.user", "no-reply@layoverconnect.com");
        props.setProperty("mail.smtp.password", "N4p19840!!!");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.auth", "true");

        return props;
    }

    public String sendMail(String from, String to, String subject, String msgBody) {
        Properties props = mailProperties();
        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    "no-reply@layoverconnect.com", "N4p19840!!!");// Specify the Username and the PassWord
            }
        });

        mailSession.setDebug(false);

        try {
            Transport transport = mailSession.getTransport();

            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, to);

            MimeMultipart multipart = new MimeMultipart();

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setContent(msgBody, "text/html");

            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

//            transport.connect(to, subject, msgBody)
            transport.connect("outlook.mail.us-east-1.awsapps.com"  , "no-reply@layoverconnect.com", "N4p19840!!!");
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
            return "SUCCESS";
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return "INVALID_EMAIL";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public static void main(String args[]) {
        System.out.println(new MailSender().sendMail("no-reply@layoverconnect.com", "sahidalom6900@gmail.com", "Subject", "Message"));
    }
}