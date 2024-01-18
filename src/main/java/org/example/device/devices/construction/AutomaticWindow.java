package org.example.device.devices.construction;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.device.state_pattern.UsingState;
import org.example.house.Room;

/**
 * AutomaticWindow class - construction device
 */
public class AutomaticWindow extends Device {

    public AutomaticWindow(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "AutomaticWindow";
        electricity = new Electricity(2);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new UsingState(this);
    }


}
