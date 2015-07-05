package com.flipkart.AddressBook.controllers;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Controller
@Path("/health")
public class HealthController {
    @GET
    @Produces("application/json")
    public String health() {
        return "Hello World!";
    }
}
