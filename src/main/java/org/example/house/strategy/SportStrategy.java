package org.example.house.strategy;

import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.house.Room;

public class SportStrategy implements Strategy{

    private int timeCounter;
    @Override
    public void everythingIsHappeningAsISaid(Creature creature) {
        Person person = (Person) creature;
        switch(timeCounter) {
            case 0 : person.sport(); break;
            case 2 : person.goToAnotherRoomByName(""); person.stopSporting(); break;
            case 4 : person.sport();
            case 6 : person.stopSporting();
            case 7 : person.goToEat();
            case 8 : person.stopEating();
            default: break;
        }
        timeCounter++;
    }
}
