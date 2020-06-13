package facets;

import enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Epic extends Point {
    public List<Story> getStories() {
        return stories;
    }

    private List<Story> stories;
    private static Story lastStory;

    public Epic(String ID, String name) {
        super(ID, name);
    }

    public Epic(String ID, String name, String description, Status status) {
        super(ID, name, description, status);
    }

    public Epic(String ID, String name, Status status) {
        super(ID, name, status);
    }

    public List<Story> getAllStories(Status status) {
        return stories.stream().filter(story -> story.status == status).collect(Collectors.toList());
    }

    public List<Story> getAllStories(Status status, String epicId) {
        return stories.stream().filter(story -> story.status == status && story.ID.contentEquals(epicId)).collect(Collectors.toList());
    }

}
