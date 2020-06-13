package facets;

import enums.Status;

public class Point {
    protected String ID;
    protected String name;
    protected String description;
    protected Status status;

    public Point(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.status = Status.WAITING;
        this.description = "";
    }

    public Point(String ID, String name, String description, Status status) {
        this.ID = ID;
        this.name = name;
        this.status = status;
        this.description = description;
    }

    public Point(String ID, String name, Status status) {
        this.ID = ID;
        this.name = name;
        this.status = status;
        this.description = "";
    }


    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

}
