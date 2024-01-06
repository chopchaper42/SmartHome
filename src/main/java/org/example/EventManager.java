package org.example;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class EventManager {

    private static EventManager instance;
    @Getter
    private List<Task> events = new LinkedList<>();

    public static EventManager getInstance() {
        if (instance == null)
            instance = new EventManager();

        return instance;
    }

    public void addEvent(Task task) {
        events.add(task);
    }


}
