package com.flipkart.AddressBook.services;

import com.flipkart.AddressBook.models.Contact;
import com.flipkart.AddressBook.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact getById(Long id) {
        return contactRepository.getById(id);
    }

    public List<Contact> getAll() { return contactRepository.getAll(); }
}
