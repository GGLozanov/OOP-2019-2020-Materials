package projects;

import enums.Vocation;
import people.Employee;

import java.util.List;

public class Project {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public Project(List<Employee> employees) {
        this.employees = employees;
    }
}
