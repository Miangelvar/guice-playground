package org.example.misc;

import java.util.Optional;
import java.util.Set;

public interface PersonRepository {

    Set<Person> findAll();
    Optional<Person> findByFirstNameContaining(String partialFirstName);
    Set<Person> findByAge(int age);
    Set<Person> findByAgeBetween(int minAge, int maxAge);

    long countByLastNameIgnoreCase(String lastName);
}
