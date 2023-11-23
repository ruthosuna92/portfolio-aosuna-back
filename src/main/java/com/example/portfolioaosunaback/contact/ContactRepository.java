package com.example.portfolioaosunaback.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    //@Query("SELECT s FROM Contact s WHERE s.email = ?1")
    Optional<Contact> findContactByEmail(String email);
}
