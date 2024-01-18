package org.example.events.creatures_events;

import org.example.creature.people.Person;
import org.example.events.Event;

public class Sporting  extends Event {
    private Person person;

    public Sporting(Person person) {
        this.person = person;
        this.eventType = eventType.SPORTING;
    }
}
