package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * ElectricStove class - kitchen device
 */
public class ElectricStove extends Device {

    public ElectricStove(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "ElectricStove";
        electricity = new Electricity(31);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }


}
