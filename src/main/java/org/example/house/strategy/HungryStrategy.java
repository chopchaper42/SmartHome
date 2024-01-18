package org.example.house.strategy;

import org.example.creature.Creature;
import org.example.creature.people.Person;

import java.util.Random;

public class HungryStrategy implements Strategy{

    private int timeCounter;

    @Override
    public void everythingIsHappeningAsISaid(Creature creature) {
        Person person = (Person) creature;
        switch(timeCounter) {
            case 0 : person.goToEat(); break;
            case 2 : person.stopEating(); break;
            //case 4 : person.fillThePetFeeder
            default: break;
        }
        timeCounter++;
    }
}
