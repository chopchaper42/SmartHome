package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * Computer class - entertainment device
 */
public class Computer extends Device implements EntertainmentDeviceInterface{

    public Computer(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "Computer";
        electricity = new Electricity(20);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }


}
