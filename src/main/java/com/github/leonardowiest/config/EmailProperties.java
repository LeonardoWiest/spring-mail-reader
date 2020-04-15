package com.github.leonardowiest.config;

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

}
