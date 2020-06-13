package lozanov.staff;

import lozanov.people.Person;

public abstract class MedicalEmployee extends Person {
    public long getWorkExperience() {
        return workExperience;
    }

    long workExperience;

    public MedicalEmployee() {
        this("Default", "Defaultson", 2);
    }

    public MedicalEmployee(String firstName, String lastName, long workExperience) {
        super(firstName, lastName);
        this.workExperience = workExperience;
    }



}
