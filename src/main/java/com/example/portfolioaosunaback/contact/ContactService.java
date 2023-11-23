package com.example.portfolioaosunaback.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public void addNewContact(Contact contact) {
        Optional<Contact> contactOptional = contactRepository
                .findContactByEmail(contact.getEmail());
        if (contactOptional.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        contactRepository.save(contact);
        System.out.println("Contact saved successfully: " + contact);
    }

    public void deleteContact(Long contactId) {
        boolean exists = contactRepository.existsById(contactId);
        if(!exists){
            throw new IllegalStateException("Contact with id " + contactId + " does not exist");
        }
        contactRepository.deleteById(contactId);
    }
}
