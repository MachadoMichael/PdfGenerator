package com.mcubed.pdfGenerator.entities;

import com.mcubed.pdfGenerator.config.SmtpConfig;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailSender {

    private JavaMailSenderImpl mailSender;

    public MailSender(SmtpConfig smtpConfig) {
        mailSender = new JavaMailSenderImpl();

        mailSender.setHost(smtpConfig.getMailHost());
        mailSender.setPort(smtpConfig.getMailPort());
        mailSender.setUsername(smtpConfig.getMailUsername());
        mailSender.setPassword(smtpConfig.getMailPassword());

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(props);
    }

    public JavaMailSenderImpl getMailSender() {
        return mailSender;
    }
}
