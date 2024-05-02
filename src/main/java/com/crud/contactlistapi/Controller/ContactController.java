package com.crud.contactlistapi.Controller;

import com.crud.contactlistapi.entity.Contact;
import com.crud.contactlistapi.service.ContactService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contacts")
@Validated
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public Iterable<Contact> getContactData() {
        return contactService.getContactData();
    }

    @GetMapping("/{id}")
    public Contact getContactDataById(@PathVariable Integer id) {
        return contactService.getContactDataById(id);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@Validated @RequestBody Contact newContact) {
        return contactService.createContact(newContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Integer id, @RequestBody @NonNull Contact updateContact) {
        return contactService.updateContact(id, updateContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Integer id) {
        return contactService.deleteContact(id);
    }
}
