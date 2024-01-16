package org.example.creature.creatures_factory;

import org.example.creature.Creature;
import org.example.creature.people.Adult;
import org.example.creature.people.Child;
import org.example.creature.people.Person;
import org.example.house.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating people (Factory Method pattern)
 */
public class PeopleFactory extends AbstractCreatureFactory<HumanTypes>{

    private static PeopleFactory instance = null;

    /**
     * Private singleton constructor
     */
    private PeopleFactory(){}

    /**
     * Method for getting PeopleFactory instance - Singleton pattern
     * @return instance of PeopleFactory
     */
    public static PeopleFactory getInstance() {
        if (instance == null) { instance = new PeopleFactory();}
        return instance;
    }

    private final List<Person> people = new ArrayList<>();
    @Override
    public Creature createCreature(Room currentRoom, HumanTypes creatureType) {
        Person person = switch (creatureType) {
            case ADULT -> new Adult();
            case CHILD -> new Child();
        };
        people.add(person);
        return person;
    }
}
