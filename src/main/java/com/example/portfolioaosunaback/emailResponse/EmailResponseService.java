package com.example.portfolioaosunaback.emailResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class EmailResponseService implements EmailResponseInterface{
    private final JavaMailSender mailResponse;

    public EmailResponseService(JavaMailSender mailResponse) {
        this.mailResponse = mailResponse;
    }

    private static final Logger logger = LoggerFactory.getLogger(EmailResponseService.class);

    // ... (rest of your class)
    @Override
    public void sendResponse(String to, String subject, String htmlContent, String contactName) {
        MimeMessage mimeMessage = mailResponse.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom("aosunadeveloper@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);

            // Include the name and email in the HTML body
            String emailBody = String.format("<p>Name: %s</p><p>Email: %s</p><p>%s</p>", contactName, to, htmlContent);
            helper.setText(emailBody, true);

            // You can add inline images like this:
            // FileSystemResource resource = new FileSystemResource(new File("path/to/image.png"));
            // helper.addInline("image1", resource);

            mailResponse.send(mimeMessage);
        }  catch (MessagingException e) {
            // Log the exception using a logging framework
            logger.error("Error sending email", e);

            // Rethrow the exception or handle it as needed
            throw new RuntimeException(e);
        }
    }
}
