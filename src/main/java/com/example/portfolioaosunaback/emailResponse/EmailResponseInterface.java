package com.example.portfolioaosunaback.emailResponse;

public interface EmailResponseInterface {

    void sendResponse(String to, String subject, String text, String contactName);
}
