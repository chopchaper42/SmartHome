package org.example.device;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.device.state_pattern.DeviceState;
import org.example.house.Room;

@Setter
@Getter
public abstract class Device {

    //private final DeviceTypes type;
    private Room currentRoom;
    private boolean isFree = true;

    //electricity wasting
    private final int onElectricityWasting;
    private final int offElectricityWasting;

    private final int brokenElectricityWasting;
    //**************************************

    //State pattern
    private DeviceState stateOfDevice;
    //*******************************

    protected Device(Room currentRoom, int onElectricityWasting, int offElectricityWasting, int brokenElectricityWasting) {
        this.currentRoom = currentRoom;
        this.onElectricityWasting = onElectricityWasting;
        this.offElectricityWasting = offElectricityWasting;
        this.brokenElectricityWasting = brokenElectricityWasting;
    }

    /**
     *  If device is off, state is changing to on
     * @param person person turning on the device
     * @return true if turning on was successful, false overwise
     */
    public boolean turnOn(Person person) {
        return stateOfDevice.turnOn(person);
    }

    /**
     * If device is on, state is changing to off
     * @param person person turning off the device
     * @return true if turning off was successful, false overwise
     */
    public boolean turnOff(Person person) {
        return stateOfDevice.turnOff(person);
    }

    /**
     * Returns true if interaction done
     * @param creature creature who interact with device
     * @return
     */
    public boolean interact(Creature creature) {
        return stateOfDevice.interact(creature);
    }
}
