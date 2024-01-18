package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * TV class - entertainment device
 */
public class TV extends Device implements EntertainmentDeviceInterface{

    public TV(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "TV";
        electricity = new Electricity(30);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }


}
