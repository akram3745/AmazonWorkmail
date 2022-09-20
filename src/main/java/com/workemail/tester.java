package com.workemail;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

class tester {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("mail.smtp.host" , "smtp.gmail.com");
        props.put("mail.stmp.user" , "sahidalom00@gmail.com");

        //To use TLS Authenticator authentication = new SmtpAuthenticator();
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", "Sahid0@");
        //To use SSL
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", 
            "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Authenticator authentication = new SmtpAuthenticator();
        Session session  = Session.getDefaultInstance( props , authentication);
        String to = "sahidalom00@gmail.com";
        String from = "sahidalom1234@gmail.com";
        String subject = "Testing...";
       
        javax.mail.Message msg = new MimeMessage(session);
//        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, 
                new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText("Working fine..!");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com" , 465 , "", "Sahid0@");
            transport.send(msg);
            System.out.println("fine!!");
        }
        catch(Exception exc) {
        	exc.printStackTrace();
            System.out.println(exc);
        }
    }
}