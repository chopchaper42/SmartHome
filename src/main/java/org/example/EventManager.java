package org.example;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class EventManager {

    private static EventManager instance;
    @Getter
    private List<Task> events = new LinkedList<>();

    /**
     * Returns the singleton instance of the EventManager
     * @return the instance of the EventManager
     */
    public static EventManager getInstance() {
        if (instance == null)
            instance = new EventManager();

        return instance;
    }

    /**
     * Adds the task to the tasks list
     * @param task the task to add
     */
    public void addEvent(Task task) {
        events.add(task);
    }


}
