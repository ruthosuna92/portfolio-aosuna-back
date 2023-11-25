package com.example.portfolioaosunaback.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSender {

    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String text, String contactName) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("aosunadeveloper@gmail.com");
        simpleMailMessage.setTo("alejandraop391@gmail.com");
        simpleMailMessage.setSubject(subject);

        String emailBody = String.format("Name: %s\nEmail: %s\n\n%s", contactName, to, text);
        simpleMailMessage.setText(emailBody);

        this.mailSender.send(simpleMailMessage);
    }
}
