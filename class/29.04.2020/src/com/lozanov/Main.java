package com.lozanov;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Person> people = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            people.add(generatePerson())
        }
    }

    public static Person generatePerson(String firstName, String lastName) {
        Person.Sex sex = Person.Sex.values()[ThreadLocalRandom.current().nextInt(1)];

        String birthday = ThreadLocalRandom.current().

        return new Person();
    }


}
