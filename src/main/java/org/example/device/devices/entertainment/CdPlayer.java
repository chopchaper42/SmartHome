package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * CdPlayer class - entertainment device
 */
public class CdPlayer extends Device implements EntertainmentDeviceInterface {

    public CdPlayer(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "CdPlayer";
        electricity = new Electricity(7);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }



}
