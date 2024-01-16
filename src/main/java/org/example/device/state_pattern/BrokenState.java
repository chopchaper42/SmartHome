package org.example.device.state_pattern;

import org.example.creature.Creature;
import org.example.creature.people.Adult;
import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.device_events.RepairingDevice;

public class BrokenState implements DeviceState{

    private final Device device;

    public BrokenState(Device device) {
        this.device = device;
    }

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


    @Override
    public boolean breakDevice(Creature creature) {return false;}

    /**
     * Attempt to repair the device. If the person is an adult, the device is set free, transitions to the UsingState,
     * and a RepairingDevice event is triggered.
     *
     * @param person The person attempting to repair the device.
     * @return True if the device is successfully repaired by an adult, false otherwise.
     */
    @Override
    public boolean repairDevice(Person person) {
        if(person instanceof Adult){
            device.setFree(true);
            device.setStateOfDevice(new UsingState(device));
            new RepairingDevice(person, device);
            return true;
        }
        return false;
    }

}
