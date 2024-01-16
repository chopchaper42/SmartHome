package org.example.creature.creatures_factory;

import org.example.creature.Creature;
import org.example.creature.CreaturesEnum;
import org.example.house.Room;

public abstract class AbstractCreatureFactory<T> {
    public abstract Creature createCreature(String name, int age, Room currentRoom, T creatureType);
}
