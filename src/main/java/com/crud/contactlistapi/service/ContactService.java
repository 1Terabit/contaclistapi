package com.crud.contactlistapi.service;

import com.crud.contactlistapi.entity.Contact;
import com.crud.contactlistapi.controller.exception.ResourceNotFoundException;
import com.crud.contactlistapi.repository.ContactRepository;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Iterable<Contact> getContactData() {
        return contactRepository.findAll();
    }

    public Contact getContactDataById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Contact> createContact(@Validated Contact newContact) {
        Contact createdContact = contactRepository.save(newContact);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    public ResponseEntity<Contact> updateContact(Integer id, @NonNull Contact updateContact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + id));

        existingContact.setName(updateContact.getName());
        existingContact.setEmail(updateContact.getEmail());

        Contact savedContact = contactRepository.save(existingContact);
        return ResponseEntity.ok(savedContact);
    }

    public ResponseEntity<Void> deleteContact(Integer id) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + id));

        contactRepository.delete(existingContact);
        return ResponseEntity.noContent().build();
    }
}
