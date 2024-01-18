package org.example.events.creatures_events;

import org.example.creature.people.Person;
import org.example.events.Event;

public class Eating extends Event {
    private Person person;

    public Eating(Person person) {
        this.person = person;
        this.eventType = eventType.EATING;
    }
}
