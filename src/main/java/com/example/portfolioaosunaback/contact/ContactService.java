package com.example.portfolioaosunaback.contact;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    public List<Contact> getContacts() {
        return List.of(
                new Contact(
                        1L,
                        "Demo name",
                        "Demo Subject",
                        "Demo@email.com",
                        "Demo Description"
                )
        );
    }
}
