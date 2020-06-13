package lozanov.patients;

import lozanov.people.Person;

public class Patient extends Person {
    public String getEGN() {
        return EGN;
    }

    String EGN;

    public Patient() {
        this("Default", "Defaultson", "2312512515");
    }

    public Patient(String EGN) {
        this.EGN = EGN;
    }

    public Patient(String firstName, String lastName, String EGN) {
        super(firstName, lastName);
        this.EGN = EGN;
    }
}
