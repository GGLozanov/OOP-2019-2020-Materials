package facets;

import enums.Status;
import people.Employee;

public class Task extends Point {
    private Employee assignee;

    public Task(String ID, String name) {
        super(ID, name);
    }

    public Task(String ID, String name, String description, Status status) {
        super(ID, name, description, status);
    }

    public Task(String ID, String name, Status status) {
        super(ID, name, status);
    }

    public Task(String ID, String name, Employee assignee) {
        super(ID, name);
        this.assignee = assignee;
    }

    public Task(String ID, String name, String description, Status status, Employee assignee) {
        super(ID, name, description, status);
        this.assignee = assignee;
    }

    public Task(String ID, String name, Status status, Employee assignee) {
        super(ID, name, status);
        this.assignee = assignee;
    }
}
