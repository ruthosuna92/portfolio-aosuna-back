package com.example.portfolioaosunaback.contact;

import jakarta.persistence.*;

@Entity
@Table
public class Contact {
    @Id
    @SequenceGenerator(
            name = "contact_sequence",
            sequenceName = "contact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contact_sequence"
    )
    private Long id;
    private String name;
    private String subject;
    private String email;
    private String description;

    public Contact() {
    }

    public Contact(Long id,
                   String name,
                   String subject,
                   String email,
                   String description) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.description = description;
    }

    public Contact(String name,
                   String subject,
                   String email,
                   String description) {
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
