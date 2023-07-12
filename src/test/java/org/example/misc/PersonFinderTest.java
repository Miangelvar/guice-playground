package org.example.misc;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonFinderTest extends PersonFinderHook {

    @Inject
    PersonFinder personFinder;

    @Test
    void findAll() {
        var persons = personFinder.findAll();
        persons.forEach(System.out::println);
        assertFalse(persons.isEmpty());
    }

    @Test
    void findByFirstNameContaining() {
    }

    @Test
    void findByAge() {
    }

    @Test
    void findByAgeBetween() {
    }
}