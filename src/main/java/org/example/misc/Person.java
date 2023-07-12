package org.example.misc;

import com.github.javafaker.Faker;

import java.time.LocalDate;

public interface Person {
    String getFirstName();

    String getLastName();
    LocalDate getBirthdate();

    default int getAge() {
        return getBirthdate().until(LocalDate.now()).getYears();
    }

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    static Person from(Faker faker) {
        return new SimplePerson(faker);
    }

    static PersonBuilder with() {
        return new PersonBuilder();
    }

    class PersonBuilder {
        private String firstName;
        private String lastName;
        private LocalDate birthdate;

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Person create() {
            return new SimplePerson(firstName, lastName, birthdate);
        }
    }

}
