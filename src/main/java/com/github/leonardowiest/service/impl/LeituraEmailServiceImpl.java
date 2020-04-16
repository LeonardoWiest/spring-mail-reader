package com.github.leonardowiest.service.impl;

import java.util.Collections;
import java.util.List;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.config.EmailProperties;
import com.github.leonardowiest.service.LeituraEmailService;

@Service
public class LeituraEmailServiceImpl implements LeituraEmailService {

	@Autowired
	private EmailProperties emailProperties;

	private static Session session;

	private static Store store;

	@Override
	public List<?> read() {
		System.out.println("Executando o método read().");

		emailProperties.getUsername();

		session = this.createSession();

		connect();

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

		return Collections.emptyList();
	}

	private Session createSession() {

		Session instance = Session.getInstance(emailProperties.loadProperties(), new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(emailProperties.getUsername(), emailProperties.getPassword());
			}
		});

		instance.setDebug(true);

		return instance;
	}

	private void connect() {

		
			try {
				store = session.getStore(emailProperties.getProtocol());
			} catch (NoSuchProviderException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				store.connect(emailProperties.getHost(), emailProperties.getPort(), emailProperties.getUsername(),
						emailProperties.getPassword());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				System.out.println();
			}

			System.out.println(store.isConnected());

			try {
				store.getDefaultFolder();
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		

	}

}
