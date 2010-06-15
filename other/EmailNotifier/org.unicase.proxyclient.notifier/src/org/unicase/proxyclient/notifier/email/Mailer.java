/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.login.Configuration;

/**
 * Mail Service.
 * 
 * @author fuesescc
 */
public class Mailer extends Authenticator {
	
	private MailerInfo mailerInfo;
	private Session session;

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
		// props.put("mail.smtps.socketFactory.port", "995");
		// props.put("mail.smtps.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");
		// props.put("mail.smtps.socketFactory.fallback", "false");
		// props.put("mail.smtp.ssl.checkserveridentity", "true");
		props.put("mail.smtp.ssl.enable", useSSL);
		props.put("mail.mime.charset", "UTF-8");
		props.put("mail.smtp.quitwait", "false");

		session = Session.getInstance(props, this);

		session.setDebug(true);
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		String user = mailerInfo.getUsername();
		String password = mailerInfo.getPassword();
		
		return new PasswordAuthentication(user, password);
	}
	
	public boolean send(String to, String subject, String msg) {

		try {
			MimeMessage message = new MimeMessage(session);
			message.setHeader("Content-Type", "UTF-8");
			message.setHeader("Content-Transfer-Encoding", "8bit");
			message.setFrom(new InternetAddress(mailerInfo.getSender(), true));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			// set message content, type, and encoding, and send the message
			//message.setContent(msg, "text/plain; charset=UTF-8");
			message.setContent(msg, "text/html; charset=UTF-8");
			Transport.send(message);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println( e.getMessage() );
			return  false;
		}

	}
}
