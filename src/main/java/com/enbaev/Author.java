package com.enbaev;

import java.util.UUID;

public class Author {
    String id;
    String firstName;
    String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.id = UUID.randomUUID().toString();
        this.lastName = lastName;
    }
}
