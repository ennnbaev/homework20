package com.enbaev;

import java.util.UUID;

public class Author {
    String id;
    String firstName;
    String lastName;

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.id = UUID.randomUUID().toString();
        this.lastName = lastName;
    }
}
