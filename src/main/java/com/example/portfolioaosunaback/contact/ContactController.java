package com.example.portfolioaosunaback.contact;

import com.example.portfolioaosunaback.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "contacts")
public class ContactController {
    private final ContactService contactService;

    private final EmailSender emailSender;
    @Autowired
    public ContactController(ContactService contactService, EmailSender emailSender) {
        this.contactService = contactService;
        this.emailSender = emailSender;
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @PostMapping
    public ResponseEntity<String> registerNewContact(@RequestBody Contact contact) {

        contactService.addNewContact(contact);
        emailSender.sendEmail(contact.getEmail(),
                contact.getSubject(),
                contact.getDescription(),
                contact.getName());
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping(path = "{contactId}")
    public void deleteContact(@PathVariable("contactId") Long contactId){
        contactService.deleteContact(contactId);


    }

}
