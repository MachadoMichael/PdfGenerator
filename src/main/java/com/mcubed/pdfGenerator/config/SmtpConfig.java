package com.mcubed.pdfGenerator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class SmtpConfig {

        @Value("${spring.mail.host}")
        private String mailHost;

        @Value("${spring.mail.port}")
        private int mailPort;

        @Value("${spring.mail.username}")
        private String mailUsername;

        @Value("${spring.mail.password}")
        private String mailPassword;


        public String getMailHost() {
                return mailHost;
        }

        public int getMailPort() {
                return mailPort;
        }

        public String getMailUsername() {
                return mailUsername;
        }

        public String getMailPassword() {
                return mailPassword;
        }
}
