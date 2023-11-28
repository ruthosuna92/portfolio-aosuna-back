package com.example.portfolioaosunaback.contact;

import com.example.portfolioaosunaback.email.EmailSender;
import com.example.portfolioaosunaback.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping(path = "contacts")
public class ContactController {
    private final ContactService contactService;

    private final EmailSender emailSender;
    private final EmailSenderService emailSenderService;

    @Autowired
    public ContactController(ContactService contactService, EmailSender emailSender, EmailSenderService emailSenderService) {
        this.contactService = contactService;
        this.emailSender = emailSender;
        this.emailSenderService = emailSenderService;

    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @PostMapping
    public ResponseEntity<?> registerNewContact(@RequestBody Contact contact) {

        contactService.addNewContact(contact);
        emailSender.sendEmail(contact.getEmail(),
                contact.getSubject(),
                contact.getDescription(),
                contact.getName());

        Context context = new Context();
        context.setVariable("message", contact.getDescription());

        emailSenderService.sendEmailWithHtmlTemplate(contact.getEmail(), "Thank you for your interest in Ale Developer", "email-template", context);

        return ResponseEntity.ok("Success");
    }

    @DeleteMapping(path = "{contactId}")
    public void deleteContact(@PathVariable("contactId") Long contactId){
        contactService.deleteContact(contactId);


    }

}
