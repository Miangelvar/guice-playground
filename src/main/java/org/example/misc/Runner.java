package org.example.misc;

import com.google.inject.Guice;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;


public class Runner {



    public static void main(String[] args) {

        var injector = Guice.createInjector(new PersonModule());
        var finder = injector.getInstance(PersonFinder.class);
        System.out.println(finder.findByAge(26));
        System.out.println(finder.findByAgeBetween(20, 30));

        finder.findAll()
                .forEach(System.out::println);

    }
}
