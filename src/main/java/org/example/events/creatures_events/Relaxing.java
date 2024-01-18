package org.example.events.creatures_events;

import org.example.creature.people.Person;
import org.example.events.Event;

public class Relaxing extends Event {
    private Person person;

    public Relaxing(Person person) {
        this.person = person;
        this.eventType = eventType.RELAXING;
    }
}
