package com.crud.contactlistapi.data;

import com.crud.contactlistapi.entity.Contact;
import com.crud.contactlistapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader {

    private final ContactRepository contactRepository;

    @Autowired
    public DataLoader(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void loadTestData() {
        Contact contact1 = new Contact();
        contact1.setName("John Doe");
        contact1.setEmail("john@example.com");
        contact1.setCreatedAt(LocalDateTime.now());

        Contact contact2 = new Contact();
        contact2.setName("Jane Smith");
        contact2.setEmail("jane@example.com");
        contact2.setCreatedAt(LocalDateTime.now());

        contactRepository.save(contact1);
        contactRepository.save(contact2);
    }
}
