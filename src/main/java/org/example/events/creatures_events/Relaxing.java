package org.example.events.creatures_events;

import org.example.creature.people.Person;
import org.example.events.Event;

import java.util.logging.Logger;

public class Relaxing extends Event {
    private Person person;
    private static Logger logger = Logger.getLogger(Relaxing.class.getName());

    public Relaxing(Person person) {
        super();
        this.person = person;
        this.eventType = eventType.RELAXING;
        logger.info(person.getName() + " is relaxing.");
    }

    @Override
    public String toString() {
        return person.getName() + " is relaxing.\n";
    }
}
