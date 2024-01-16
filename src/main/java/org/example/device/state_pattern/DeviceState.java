package org.example.device.state_pattern;

import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.device.Device;

/**
 * Interface class for states of device (State pattern)
 */
public interface DeviceState {


    /**
     * If device is off, method changing state to on
     * @param person person who does turning on
     * @return true if turning on was successful
     */
    boolean turnOn(Person person);


    /**
     * If device is on, method changing state to off
     * @param person person who does turning off
     * @return true if turning off was successful
     */
    boolean turnOff(Person person);


    /**
     * Doing interaction with creature and device
     * @param creature creature who does interaction
     * @return true if interaction was successful
     */
    boolean interact(Creature creature);

    /**
     * Repair device
     * @param person person who repairs device
     * @return true if repairing was successful
     */
    boolean repairDevice(Person person);

    boolean breakDevice(Creature creature);

}
