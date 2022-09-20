package com.workemail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
	public SmtpAuthenticator() {

		super();
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		String username = "sahidalom6900@gmail.com";
		String password = "Sahid0@";
		if ((username != null) && (username.length() > 0) && (password != null) && (password.length() > 0)) {

			return new PasswordAuthentication(username, password);
		}

		return null;
	}
}