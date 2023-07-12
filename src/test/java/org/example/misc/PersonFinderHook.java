package org.example.misc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class PersonFinderHook {
    private static final Injector injector = Guice.createInjector(new PersonModule());

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setUp() {
        injector.injectMembers(this);
    }
}
