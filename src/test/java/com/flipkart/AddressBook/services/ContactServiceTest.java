package com.flipkart.AddressBook.services;

import com.flipkart.AddressBook.models.Contact;
import com.flipkart.AddressBook.repositories.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ContactServiceTest {
    private ContactService contactService;

    @Mock
    private ContactRepository mockContactRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        contactService = new ContactService(mockContactRepository);
    }

    @Test
    public void shouldGetContactForGivenId() {
        Contact expectedContact = new Contact();
        when(mockContactRepository.getById(1L)).thenReturn(expectedContact);

        Contact receivedContact = contactService.getById(1L);

        assertThat(receivedContact, is(expectedContact));
    }

    @Test
    public void shouldGetAllContacts() {
        List<Contact> expectedContacts = newArrayList();
        when(mockContactRepository.getAll()).thenReturn(expectedContacts);

        List<Contact> receivedContacts = contactService.getAll();

        assertThat(receivedContacts, is(expectedContacts));
    }
}