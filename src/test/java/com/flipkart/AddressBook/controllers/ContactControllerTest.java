package com.flipkart.AddressBook.controllers;

import com.flipkart.AddressBook.models.Contact;
import com.flipkart.AddressBook.services.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ContactControllerTest {
    private ContactController contactController;
    @Mock
    private ContactService contactService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        contactController = new ContactController(contactService);
    }

    @Test
    public void shouldGetContactById() {
        Contact expectedContact = new Contact();
        when(contactService.getById(1L)).thenReturn(expectedContact);

        Contact receivedContact = contactController.getById(1L);

        assertThat(receivedContact, is(expectedContact));
    }

    @Test
    public void shouldGetAllContacts() {
        List<Contact> expectedContacts = newArrayList();
        when(contactService.getAll()).thenReturn(expectedContacts);

        List<Contact> receivedContacts = contactController.getAll();

        assertThat(receivedContacts, is(expectedContacts));
    }
}
