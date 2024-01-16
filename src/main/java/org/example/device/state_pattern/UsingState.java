package org.example.device.state_pattern;

import org.example.creature.Creature;
import org.example.creature.animals.Animal;
import org.example.creature.people.Adult;
import org.example.creature.people.Child;
import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.device_events.BreakingDevice;
import org.example.events.device_events.TurningOffTheDevice;
import org.example.events.device_events.UsingDevice;

/**
 * One off three devices state (State pattern)
 */
public class UsingState implements DeviceState{
    private final Device device;

    public UsingState(Device device) {
        this.device = device;
    }

    /**
     * Turning on the device
     * @param person
     * @return true because device turned on already
     */
    @Override
    public boolean turnOn(Person person) {
        return true;
    }


    /**
     * Turns off the device, triggering the TurningOffTheDevice event and transitioning
     * the device to the OffState.
     *
     * @param person The person initiating the turn-off process.
     * @return Always returns true to indicate that the turn-off process has started.
     */
    @Override
    public boolean turnOff(Person person) {
        new TurningOffTheDevice(person, device);
        device.setStateOfDevice(new OffState(device));
        //device.getCounter().increment(device.getConsumption());
        return true;
    }

    /**
     * Represents the interaction with the device by a creature. If the creature is a person,
     * a UsingDevice event is created. If the creature is a child or an animal, there is a
     * probability of breaking the device, and a BreakingDevice event is created accordingly.
     * Animal or child can't use the device
     * @param creature The creature interacting with the device.
     * @return Always returns true to indicate that the interaction has started.
     */
    @Override
    public boolean interact(Creature creature) {
        device.setFree(false);
        if(creature instanceof Person person) {
            new UsingDevice(person, device);
        }
        else if (creature instanceof Child || creature instanceof Animal) {
            // Determine the probability of breaking
            double breakProbability;
            if (creature instanceof Child) {
                breakProbability = 0.5; // 50% chance of breaking for children
            } else {
                breakProbability = 0.25; // 25% chance of breaking for animals
            }

            // Check if the device breaks
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
}
