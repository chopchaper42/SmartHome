package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * Mobile class - entertainment device
 */
public class Mobile extends Device implements EntertainmentDeviceInterface{

    public Mobile(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "Mobile";
        electricity = new Electricity(15);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }



}
