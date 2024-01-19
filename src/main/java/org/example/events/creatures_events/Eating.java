package org.example.events.creatures_events;

import org.example.creature.people.Person;
import org.example.events.Event;

import java.util.logging.Logger;

public class Eating extends Event {
    private Person person;
    private static Logger logger = Logger.getLogger(Eating.class.getName());

    public Eating(Person person) {
        super();
        this.person = person;
        this.eventType = eventType.EATING;
        logger.info(person.getName() + " is eating.");
    }

    @Override
    public String toString() {
        return person.getName() + " eating.\n";
    }
}
