package org.example.device.state_pattern;

import org.example.creature.Creature;
import org.example.creature.animals.Animal;
import org.example.creature.people.Adult;
import org.example.creature.people.Child;
import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.device_events.BreakingDevice;
import org.example.events.device_events.TurningOnTheDevice;
import org.example.events.device_events.UsingDevice;

public class OffState implements DeviceState{

    private final Device device;

    public OffState(Device device) {
        this.device = device;
    }

    /**
     * Attempts to turn on the device. There is a 5% chance that the device will break during the process.
     * If the device breaks, it transitions to the BrokenState; otherwise, it transitions to the UsingState.
     *
     * @param person The person attempting to turn on the device.
     * @return True if the device is successfully turned on, false if the device breaks.
     */
    @Override
    public boolean turnOn(Person person) {
        double breakOnProbability = 0.05;
        if (Math.random() < breakOnProbability) {
            breakDevice(person);
            return false; // Device is broken
        }
        new TurningOnTheDevice(person, device);
        device.setStateOfDevice(new UsingState(device));
        return true;
    }

    /**
     * Turning off the device
     * @param person
     * @return true because device turned off already
     */
    @Override
    public boolean turnOff(Person person) {
        return true;
    }

    /**
     * Break the device and transition to the BrokenState.
     *
     * @param creature The creature breaking the device.
     * @return true because the device is broken
     */
    @Override
    public boolean breakDevice(Creature creature) {
        new BreakingDevice(creature, device);
        device.setStateOfDevice(new BrokenState(device));
        return true;
    }

    /**
     * Interaction with the device. If the creature is a person, nothing happens.
     * If the creature is a child or an animal, there is a probability of breaking the device.
     *
     * @param creature The creature interacting with the device.
     * @return True if the device is used or broken during the interaction, false otherwise.
     */
    @Override
    public boolean interact(Creature creature) {
        if(creature instanceof Person person) {
            return false;
        }
        else if (creature instanceof Child || creature instanceof Animal) {
            double breakProbability;
            if (creature instanceof Child) {
                breakProbability = 0.5;
            } else {
                breakProbability = 0.25;
            }
            if (Math.random() < breakProbability) {
                breakDevice(creature);
            }
        }
        return true;
    }

    /**
     * Attempt to repair the device. Only adults can repair the device in this state.
     *
     * @param person The person attempting to repair the device.
     * @return True if the device is successfully repaired, false otherwise.
     */
    @Override
    public boolean repairDevice(Person person) {
        if(person instanceof Adult){
            return true;
        }
        return false;
    }


}
