package org.example.creature.creatures_factory;

import org.example.creature.Creature;
import org.example.creature.CreaturesEnum;
import org.example.creature.animals.Animal;
import org.example.creature.animals.Cat;
import org.example.house.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating pets (FactoryMethod pattern)
 */
public class PetFactory extends AbstractCreatureFactory<AnimalTypes>{

    private static PetFactory instance = null;

    /**
     * Private singleton constructor
     */
    private PetFactory(){}

    /**
     * Method for getting PetFactory instance - Singleton pattern
     * @return instance of PetFactory
     */
    public static PetFactory getInstance() {
        if (instance == null) { instance = new PetFactory();}
        return instance;
    }

    private final List<Animal> animals = new ArrayList<>();
    @Override
    public Creature createCreature(Room currentRoom, AnimalTypes creatureType) {
        Animal animal = switch (creatureType) {
            case CAT -> new Cat();
        };
        animals.add(animal);
        return animal;
    }
}
