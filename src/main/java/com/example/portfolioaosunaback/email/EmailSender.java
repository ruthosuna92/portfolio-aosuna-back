package com.example.portfolioaosunaback.email;

public interface EmailSender {
    void sendEmail(String to, String subject, String  text, String contactName);
}
