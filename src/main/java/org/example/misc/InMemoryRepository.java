package org.example.misc;

import com.google.common.base.Verify;
import com.google.inject.Singleton;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class InMemoryRepository implements PersonRepository {

    private static final Set<Person> PERSONS = Set.of(
        Person.with().firstName("Miguel").lastName("Vargas").birthdate(LocalDate.of(1995, 11, 11)).create(),
        Person.with().firstName("Javier").lastName("Vargas").birthdate(LocalDate.of(2002, 4, 20)).create(),
        Person.with().firstName("Paula").lastName("Mejía").birthdate(LocalDate.of(1997, 5, 15)).create(),
        Person.with().firstName("Angélica").lastName("Bejarano").birthdate(LocalDate.of(1975, 11, 28)).create(),
        Person.with().firstName("Manlio").lastName("Vargas").birthdate(LocalDate.of(1973, 12, 3)).create()
    );

    public InMemoryRepository() {
    }

    @Override
    public Set<Person> findAll() {
        return PERSONS;
    }

    @Override
    public Optional<Person> findByFirstNameContaining(String partialFirstName) {
        Verify.verify(!partialFirstName.isBlank());
        return PERSONS.stream()
                .filter(person -> person.getFirstName().contains(partialFirstName))
                .findAny();
    }

    @Override
    public Set<Person> findByAge(int age) {
        Verify.verify(age > 0);
        return PERSONS.stream()
                .filter(person -> Period.ofYears(age).equals(Period.ofYears(person.getAge())))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<Person> findByAgeBetween(int minAge, int maxAge) {
        return PERSONS.stream()
                .filter(person -> ageBetween(person.getAge(), minAge, maxAge))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public long countByLastNameIgnoreCase(String lastName) {
        Verify.verify(!lastName.isBlank());
        return PERSONS.stream()
                .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                .count();
    }

    private boolean ageBetween(int age, int minAge, int maxAge) {
        return age >= minAge &&  age <= maxAge;
    }
}
