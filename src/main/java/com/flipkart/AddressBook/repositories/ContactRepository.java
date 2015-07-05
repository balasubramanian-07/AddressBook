package com.flipkart.AddressBook.repositories;

import com.flipkart.AddressBook.models.Contact;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContactRepository  {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Contact getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createSQLQuery("select * from contacts c where c.id = :id")
                .addEntity(Contact.class)
                .setParameter("id", id);

        Contact contact = (Contact) query.uniqueResult();
        return contact;
    }

    @Transactional
    public List<Contact> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createSQLQuery("select * from contacts")
                .addEntity(Contact.class);

        List<Contact> contacts = (List<Contact>) query.list();
        return contacts;
    }
}
