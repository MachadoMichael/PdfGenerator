package com.mcubed.pdfGenerator.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

public class EmailService {
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void send(byte[] pdfBytes, List<String> recipientsEmail) {
        recipientsEmail.forEach((recipientEmail) -> {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = null;
            try {
                helper = new MimeMessageHelper(message, true);
                helper.setTo(recipientEmail);
                helper.setSubject("PDF file");
                helper.setText("Please find the attached PDF file.");
                helper.addAttachment("attachment.pdf", new ByteArrayDataSource(pdfBytes, "application/pdf"));
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            mailSender.send(message);
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(recipientEmail);
//            message.setSubject("PDF Attachment: ");
//            message.setText("Please find the attached PDF file.");
//            message.("file.pdf", pdfBytes);
//            mailSender.send(message);
        });
    }
}
