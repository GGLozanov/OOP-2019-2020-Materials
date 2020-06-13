package facets;

import enums.Status;
import people.Employee;

import java.util.List;

public class Story extends Point {
    private int points;
    private Employee assignee;
    private List<Task> tasks;

    public Story(String ID, String name) {
        super(ID, name);
    }

    public Story(String ID, String name, String description, Status status) {
        super(ID, name, description, status);
    }

    public Story(String ID, String name, Status status) {
        super(ID, name, status);
    }

    public Story(String ID, String name, int points, Employee assignee, List<Task> tasks) {
        super(ID, name);
        this.points = points;
        this.assignee = assignee;
        this.tasks = tasks;
    }

    public Story(String ID, String name, String description, Status status, int points, Employee assignee, List<Task> tasks) {
        super(ID, name, description, status);
        this.points = points;
        this.assignee = assignee;
        this.tasks = tasks;
    }


    public Story(String ID, String name, Status status, int points, Employee assignee, List<Task> tasks) {
        super(ID, name, status);
        this.points = points;
        this.assignee = assignee;
        this.tasks = tasks;
    }

    public int getPoints() {
        return points;
    }

    public Employee getAssignee() {
        return assignee;
    }
}
