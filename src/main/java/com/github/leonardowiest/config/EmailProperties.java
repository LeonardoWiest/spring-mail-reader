package com.github.leonardowiest.config;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github.leonardowiest.util.IfNull;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@Primary
@Configuration
public class EmailProperties extends MailProperties {

	public Properties loadProperties() {

		Properties prop = new Properties();

		prop.put("spring.mail.host", IfNull.get(super.getHost(), ""));
		prop.put("spring.mail.port", IfNull.get(super.getPort(), ""));
		prop.put("spring.mail.username", IfNull.get(super.getUsername(), ""));
		prop.put("spring.mail.password", IfNull.get(super.getPassword(), ""));
		prop.put("spring.mail.default-encoding", IfNull.get(super.getDefaultEncoding(), StandardCharsets.UTF_8));
		prop.put("spring.mail.properties.*", IfNull.get(super.getProperties(), new HashMap<>()));
		prop.put("spring.mail.jndi-name", IfNull.get(super.getJndiName(), ""));
		prop.put("spring.mail.protocol", IfNull.get(super.getProtocol(), "smtp"));

		return prop;
	}
}
