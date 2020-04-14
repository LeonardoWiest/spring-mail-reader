package com.github.leonardowiest.factory.impl;

import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.ConfigurableEnvironment;

import com.github.leonardowiest.factory.LeituraEmailFactory;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Configuration
public class LeituraEmailFactoryImpl implements LeituraEmailFactory {

	@Autowired
	private ConfigurableEnvironment environment;

	private static Properties properties = new Properties();

	private static Session session;

	@PostConstruct
	public void initialize() {

		properties.put("email.username", environment.getProperty("email.username"));
		properties.put("email.password", environment.getProperty("email.password"));
	}

	@Override
	public List<?> read() {
		System.out.println("Executando o método read().");

		session = this.createSession();

		return null;
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
