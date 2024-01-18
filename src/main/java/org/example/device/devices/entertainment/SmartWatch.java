package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * SmartWatch class - entertainment device
 */
public class SmartWatch extends Device implements EntertainmentDeviceInterface{

    public SmartWatch(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "SmartWatch";
        electricity = new Electricity(4);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }


}
