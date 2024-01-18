package org.example.device.devices.sport;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.device.state_pattern.UsingState;
import org.example.house.Room;

/**
 * Running_Path class - sport device
 */
public class Running_Path extends Device implements SportDeviceInterface{

    public Running_Path(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "Running_Path";
        //usageReserve = currentUsageReserve = 600;
        electricity = new Electricity(5);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new UsingState(this);
    }




}
