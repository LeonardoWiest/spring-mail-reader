package com.github.leonardowiest.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@ConfigurationProperties(prefix = "spring.mail")
@Configuration
public class EmailProperties extends MailProperties {

	public Properties loadProperties() {

		Properties prop = new Properties();
		prop.put("spring.mail.username", super.getUsername());
		prop.put("spring.mail.password", super.getPassword());

		return prop;
	}
}
