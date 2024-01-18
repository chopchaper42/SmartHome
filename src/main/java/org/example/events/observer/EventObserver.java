package org.example.events.observer;

import org.example.events.Event;

public interface EventObserver {
    void update(Event event);

    void startingNewDay();
}
