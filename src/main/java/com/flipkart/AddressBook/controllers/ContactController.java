package com.flipkart.AddressBook.controllers;

import com.flipkart.AddressBook.models.Contact;
import com.flipkart.AddressBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getById(@PathParam("id") Long id) {
        return contactService.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAll() {
        return contactService.getAll();
    }
}
