package com.flipkart.AddressBook;

import com.flipkart.AddressBook.controllers.ContactController;
import com.flipkart.AddressBook.controllers.HealthController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(HealthController.class);
        register(ContactController.class);
    }
}
