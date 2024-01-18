package org.example.device.devices.construction;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.device.state_pattern.UsingState;
import org.example.house.Room;

/**
 * AutomaticDoor class - construction device
 */
public class AutomaticDoor extends Device implements ConstructionDeviceInterface {

    public AutomaticDoor(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "AutomaticDoor";
        electricity = new Electricity(3);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new UsingState(this);
    }

}
