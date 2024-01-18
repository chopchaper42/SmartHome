package org.example.house.strategy;

import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.house.Room;

public class RelaxingStrategy implements Strategy{

    private int timeCounter;
    @Override
    public void everythingIsHappeningAsISaid(Creature creature) {
        Person person = (Person) creature;
        switch(timeCounter) {
            case 0 : person.relax(); break;
            case 2 : person.stopRelaxing(); break;
            case 4 : person.goToEat(); break;
            case 6 : person.stopEating(); break;
            case 7 : person.goToAnotherRoomByName(""); break;
            case 8 : person.sport(); break;
            case 9 : person.stopSporting(); break;
            default: break;
        }
        timeCounter++;
    }
}
