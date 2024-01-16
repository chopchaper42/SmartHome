package org.example.creature.animals;

import org.example.creature.Creature;
import org.example.device.Device;

/**
 * Class of animal in the House
 */
public abstract class Animal extends Creature {

    @Override
    public void interactWithDevice(Device device) {
        currentDevice = device;
        device.interact(this);
    }
}
