package com.example.portfolioaosunaback.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        contactRepository.save(contact);
        System.out.println("Contacto guardado con éxito: " + contact);
    }
}
