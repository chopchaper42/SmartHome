package org.example.device.devices.sport;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.device.state_pattern.UsingState;
import org.example.house.Room;

/**
 * Orbitek class - sport device
 */
public class Orbitek extends Device implements SportDeviceInterface {

    public Orbitek(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "Orbitek";
        //usageReserve = currentUsageReserve = 600;
        electricity = new Electricity(6);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new UsingState(this);
    }



}
