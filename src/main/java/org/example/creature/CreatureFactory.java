package org.example.creature;

import org.example.creature.people.Adult;
import org.example.house.HouseControlSystem;

public class CreatureFactory {
    HouseControlSystem controlSystem;

    public CreatureFactory(HouseControlSystem controlSystem) {
        this.controlSystem = controlSystem;
    }

    public Adult createAdult() {
//        Adult adult = new Adult();
        return null;
    }
}
