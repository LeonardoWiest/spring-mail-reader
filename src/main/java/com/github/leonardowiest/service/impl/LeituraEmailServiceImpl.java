package com.github.leonardowiest.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.service.LeituraEmailService;

@Lazy(true)
@Service
public class LeituraEmailServiceImpl implements LeituraEmailService {

	private static Properties properties = null;

	private static Session session;

	@Override
	public List<?> read() {
		System.out.println("Executando o método read().");

		session = this.createSession();

		return Collections.emptyList();
	}

	private Session createSession() {

		Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(properties.getProperty("email.username"),
						properties.getProperty("email.password"));
			}
		});

		return null;
	}

}
