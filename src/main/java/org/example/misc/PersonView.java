package org.example.misc;

import lombok.Value;

import java.time.LocalDate;

@Value
public class PersonView {
    String firstName;
    String lastName;
    LocalDate birthdate;
    int age;
    String fullName;

    public PersonView(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.birthdate = person.getBirthdate();
        this.age = person.getAge();
        this.fullName = person.getFullName();
    }
}
