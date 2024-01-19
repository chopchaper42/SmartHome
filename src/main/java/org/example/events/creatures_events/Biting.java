package org.example.events.creatures_events;

import org.example.creature.animals.Animal;
import org.example.creature.people.Person;
import org.example.events.Event;

import java.util.logging.Logger;

public class Biting extends Event {
    private static Logger logger = Logger.getLogger(Biting.class.getName());
    private Animal animal;
    private Person person;

    public Biting(Animal animal, Person person) {
        super();
        this.person = person;
        this.animal = animal;
        this.eventType = eventType.BITING;
        logger.info(animal.getName() + " is biting " + person.getName());
    }

    @Override
    public String toString() {
        return animal.getName() + " is biting " + person.getName();
    }
}
