package org.example.house.strategy;

import org.example.creature.Creature;

import java.util.List;

public class NightStrategy implements Strategy {
    @Override
    public void everythingIsHappeningAsISaid(List<Creature> creatures) {
        for (Creature creature : creatures) {
            creature.sleep();
        }
    }
}
