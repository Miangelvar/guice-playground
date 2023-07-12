package org.example.misc;

import com.github.javafaker.Faker;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.util.Locale;

public class PersonModule extends AbstractModule {

    private static final Faker INSTANCE = Faker.instance(Locale.US);
    @Override
    protected void configure() {
            bind(PersonRepository.class).annotatedWith(Names.named("null")).to(NullPersonRepository.class);
            bind(PersonRepository.class).annotatedWith(Names.named("inMemory")).to(InMemoryRepository.class);
            bind(PersonFinder.class);
            bind(Faker.class).toInstance(INSTANCE);
    }
}
