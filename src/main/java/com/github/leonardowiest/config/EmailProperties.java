package com.github.leonardowiest.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@Configuration
public class EmailProperties extends MailProperties {

	public Properties loadProperties() {

		Properties prop = new Properties();

		prop.put("spring.mail.host", super.getHost());
		prop.put("spring.mail.port", super.getPort());
		prop.put("spring.mail.username", super.getUsername());
		prop.put("spring.mail.password", super.getPassword());
		prop.put("spring.mail.default-encoding", super.getDefaultEncoding());
		prop.put("spring.mail.properties.*", super.getProperties());
		prop.put("spring.mail.jndi-name", super.getJndiName());

		return prop;
	}
}
