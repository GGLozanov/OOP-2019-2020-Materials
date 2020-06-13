package lozanov.people;

public class Person {
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    String firstName;
    String lastName;

    public String getFullName() {
        return firstName + lastName;
    }

    public Person() {
        this("Default", "Defaultson");
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
