package people;

import enums.Vocation;

public class Employee {
    private String ID;
    private String firstName;
    private String lastName;
    private Vocation vocation;

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Vocation getVocation() {
        return vocation;
    }

    public Employee(String ID, String firstName, String lastName, Vocation vocation) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vocation = vocation;
    }
}
