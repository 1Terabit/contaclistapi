package com.crud.contactlistapi.repository;

import com.crud.contactlistapi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    Optional<Contact> findById(Integer id);
}
