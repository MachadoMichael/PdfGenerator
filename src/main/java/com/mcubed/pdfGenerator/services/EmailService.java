package com.mcubed.pdfGenerator.services;

import com.mcubed.pdfGenerator.config.EmailConfig;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;
import java.util.Properties;

public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailConfig emailConfig = new EmailConfig();

    public EmailService() {
        this.mailSender = createMailSender();
    }

    private JavaMailSender createMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(emailConfig.getMailHost());
        mailSender.setPort(emailConfig.getMailPort());
        mailSender.setUsername(emailConfig.getMailUsername());
        mailSender.setPassword(emailConfig.getMailPassword());

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(props);

        return mailSender;
    }

    public void send(byte[] pdfBytes, List<String> recipientsEmail) {
        recipientsEmail.forEach((recipientEmail) -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipientEmail);
            message.setSubject("PDF Attachment: ");
            message.setText("Please find the attached PDF file.");
            mailSender.send(message);
        });
    }
}
