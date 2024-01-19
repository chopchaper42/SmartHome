package org.example.events.creatures_events;

import org.example.creature.people.Person;
import org.example.events.Event;

import java.util.logging.Logger;

public class Sporting  extends Event {
    private static Logger logger = Logger.getLogger(Sporting.class.getName());
    private Person person;

    public Sporting(Person person) {
        super();
        this.person = person;
        this.eventType = eventType.SPORTING;
        logger.info(person.getName() + " is doing sport.");
    }

    @Override
    public String toString() {
        return person.getName() + " is doing sport.\n";
    }
}
