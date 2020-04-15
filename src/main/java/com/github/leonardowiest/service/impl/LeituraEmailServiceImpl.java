package com.github.leonardowiest.service.impl;

import java.util.Collections;
import java.util.List;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.config.EmailProperties;
import com.github.leonardowiest.service.LeituraEmailService;

@Lazy(true)
@Service
public class LeituraEmailServiceImpl implements LeituraEmailService {

	@Autowired
	private EmailProperties emailProperties;

	private static Session session;

	@Override
	public List<?> read() {
		System.out.println("Executando o método read().");

		emailProperties.getUsername();

		session = this.createSession();

		return Collections.emptyList();
	}

	private Session createSession() {

		Session instance = Session.getInstance(emailProperties.loadProperties(), new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(emailProperties.getUsername(), emailProperties.getPassword());
			}
		});

		return instance;
	}

}
