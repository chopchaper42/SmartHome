package org.example.creature.people;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.House;

@Getter
@Setter
public abstract class Person extends Creature {
    protected House house = House.getInstance();

    /**
     * Person interacts with device
     * @param device target device
     */
    @Override
    public void interactWithDevice(Device device) {
        currentDevice = device;
        currentDevice.setFree(false);
        device.interact(this);
    }

    /**
     * Person is going to eat
     * @return true if there is food in fridge
     */
    public boolean goToEat(){

    }



}
