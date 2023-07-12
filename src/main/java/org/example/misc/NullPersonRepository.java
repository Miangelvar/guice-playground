package org.example.misc;

import com.github.javafaker.Faker;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class NullPersonRepository implements PersonRepository {

    private final Faker faker;

    @Inject
    public NullPersonRepository(Faker faker) {
        this.faker = faker;
    }

    @Override
    public Set<Person> findAll() {
        return Stream.generate(() -> Person.from(faker))
                .limit(15)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Optional<Person> findByFirstNameContaining(String partialFirstName) {
        return Optional.empty();
    }

    @Override
    public Set<Person> findByAge(int age) {
        return Collections.emptySet();
    }

    @Override
    public Set<Person> findByAgeBetween(int minAge, int maxAge) {
        return Collections.emptySet();
    }

    @Override
    public long countByLastNameIgnoreCase(String lastName) {
        return 0;
    }
}
