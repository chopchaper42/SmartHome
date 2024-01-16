package org.example.device.state_pattern;

import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.device.Device;

public interface DeviceState {

    /**
     *
     * @param person
     * @return
     */
    boolean turnOn(Person person);

    /**
     *
     * @param person
     * @return
     */
    boolean turnOff(Person person);

    /**
     *
     * @param creature
     * @return
     */
    boolean interact(Creature creature);

}
