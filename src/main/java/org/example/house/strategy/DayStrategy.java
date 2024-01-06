package org.example.house.strategy;

import org.example.SmartHouse;
import org.example.creature.Creature;

import java.util.Random;

public class DayStrategy implements HouseStrategy {
    @Override
    public void execute() {
        if (new Random().nextInt(4) == 0) {
            SmartHouse.instance().generateTask();
        }

        for (Creature creature : SmartHouse.instance().getHumans())
            creature.doSomething();
    }
}