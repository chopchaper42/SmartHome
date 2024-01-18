package org.example.creature.animals;

import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.device.state_pattern.BrokenState;
import org.example.house.Room;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Class of animal in the House
 */
public abstract class Animal extends Creature {
    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    /**
     * Interacts with a device. If the provided device is null, the animal selects a random
     * free and non-broken device from the devices in the current room and interacts with it.
     * If no suitable device is found, a warning is logged.
     *
     * @param device the device to interact with; if null, a random device will be selected
     */
    @Override
    public void interactWithDevice(Device device) {
        if (device == null) {
            Room room = currentRoom;
            List<Device> deviceList =
                    room.getDevices().stream().filter(Device::isFree).filter(n->
                            !(n.getStateOfDevice() instanceof BrokenState)).toList();
            if(!deviceList.isEmpty()){
                Random random = new Random();
                int randomIndex = random.nextInt(deviceList.size());
                device = deviceList.get(randomIndex);
            } else {
                logger.warning("The animal " + getName() + " didn't find device to interact with.");
                return;
            }
        }
        currentDevice = device;
        device.interact(this);
    }

    //@Override
    public void stopInteract(){
        freeDevice();
    }
}
