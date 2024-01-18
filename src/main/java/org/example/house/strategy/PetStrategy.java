package org.example.house.strategy;

import org.example.creature.Creature;
import org.example.creature.animals.Animal;
import org.example.creature.people.Person;
import org.example.house.House;

import java.util.List;
import java.util.Random;

public class PetStrategy implements Strategy{

    private int timeCounter;
    @Override
    public void everythingIsHappeningAsISaid(Creature creature) {
        Animal animal = (Animal) creature;
        switch(timeCounter) {
            case 0 :
                animal.interactWithDevice(null); animal.stopInteract();
            break;
            case 1 :
                List<Creature> creaturesList = House.getInstance().getCreatures();
                if (!creaturesList.isEmpty()) {
                    Random random = new Random();
                    Creature randomPerson = creaturesList.get(random.nextInt(creaturesList.size()));
                    if (randomPerson instanceof Person) {
                        animal.bitePerson((Person) randomPerson);
                    }
                }
            break;
            default : break;
        }
    }
}
