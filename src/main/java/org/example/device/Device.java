package org.example.device;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.creature.people.Person;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.DeviceState;
import org.example.house.Room;

@Setter
@Getter
public abstract class Device {

    private Room currentRoom;
    protected boolean isFree = true;
    protected String nameOfDevice;

    protected  int onElectricityWasting;
    protected int offElectricityWasting;

    protected  int brokenElectricityWasting;

    protected DeviceState stateOfDevice;
    protected Electricity electricity;
    protected ElectricityRecord electricityRecord;

    public Device(Room currentRoom) {
        this.currentRoom = currentRoom;
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

    /**
     * Breaking device, state changes to BrokenState
     * @param creature creature who breaks the device
     * @return false if already broken, true if broken now
     */
    public boolean breakDevice(Creature creature) { return stateOfDevice.breakDevice(creature);}
}
