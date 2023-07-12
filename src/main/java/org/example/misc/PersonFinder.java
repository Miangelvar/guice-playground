package org.example.misc;

import com.google.common.base.Verify;
import com.google.inject.Singleton;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class PersonFinder {

    private final PersonRepository repository;


    @Inject
    public PersonFinder(@Named("null") PersonRepository repository) {
        this.repository = repository;
    }

    public Set<PersonView> findAll(){
        return repository.findAll()
                .stream()
                .map(PersonView::new)
                .collect(Collectors.toUnmodifiableSet());
    }
    public Optional<PersonView> findByFirstNameContaining(String partialFirstName) {
        return repository.findByFirstNameContaining(partialFirstName)
                .map(PersonView::new);
    }
    public Set<PersonView> findByAge(int age) {
        Verify.verify(age > 0);
        return repository.findByAge(age)
                .stream()
                .map(PersonView::new)
                .collect(Collectors.toUnmodifiableSet());
    }
    public Set<PersonView> findByAgeBetween(int minAge, int maxAge) {
        Verify.verify(minAge > 0);
        Verify.verify(maxAge > 0);
        return repository.findByAgeBetween(minAge, maxAge)
                .stream()
                .map(PersonView::new)
                .collect(Collectors.toUnmodifiableSet());
    }
}
