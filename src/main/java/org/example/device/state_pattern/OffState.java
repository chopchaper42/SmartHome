package org.example.device.state_pattern;

import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.device.Device;

public class OffState implements DeviceState{


    @Override
    public boolean turnOn(Person person) {
        return false;
    }

    @Override
    public boolean turnOff(Person person) {
        return false;
    }

    @Override
    public boolean interact(Creature creature) {
        return false;
    }
}
