package org.example.misc;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.ZoneId;

@Value
@AllArgsConstructor
class SimplePerson implements Person {
    String firstName;
    String lastName;
    LocalDate birthdate;

    public SimplePerson(Faker faker) {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.birthdate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
