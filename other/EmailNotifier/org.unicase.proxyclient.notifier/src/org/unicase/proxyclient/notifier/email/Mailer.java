/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Mail Service.
 * 
 * @author fuesescc
 */
public class Mailer extends Authenticator {

	private MailerInfo mailerInfo;
	private Session session;

	/**
	 * Constructor for Mailer.
	 * 
	 * @param mailerInfo Values like host, port, username etc. are contained in the MailerInfo object and are necessary
	 *            for the Mailer class to work.
	 */
	public Mailer(MailerInfo mailerInfo) {
		this.mailerInfo = mailerInfo;

		String host = mailerInfo.getHost();
		int port = mailerInfo.getPort();
		boolean useSSL = mailerInfo.useSSL();

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", useSSL);
		props.put("mail.mime.charset", "UTF-8");
		props.put("mail.smtp.quitwait", "false");

		session = Session.getInstance(props, this);
	}

	/**
	 * Method returns a new PasswordAuthentication object with the username and the password of the MailerInfo object.
	 * 
	 * @return Returns a new PasswordAuthentication object with the username and the password of the MailerInfo object.
	 */
	protected PasswordAuthentication getPasswordAuthentication() {
		String user = mailerInfo.getUsername();
		String password = mailerInfo.getPassword();

		return new PasswordAuthentication(user, password);
	}

	/**
	 * Method to send emails.
	 * 
	 * @param to email address of the receiver.
	 * @param subject Subject of message.
	 * @param msg Message body.
	 * @return boolean value that indicates whether the email has been sent or not.
	 */
	public boolean send(String to, String subject, String msg) {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setHeader("Content-Type", "UTF-8");
			message.setHeader("Content-Transfer-Encoding", "8bit");
			message.setFrom(new InternetAddress(mailerInfo.getSender(), true));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(msg, "text/html; charset=UTF-8");
			Transport.send(message);
			return true;

		} catch (IllegalWriteException e) {
			return false;
		} catch (IllegalStateException e) {
			return false;
		} catch (MessagingException e) {
			return false;
		}
	}
}
