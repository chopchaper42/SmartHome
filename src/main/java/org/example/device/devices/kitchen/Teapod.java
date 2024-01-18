package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * Teapod class - kitchen device
 */
public class Teapod extends Device {

    public Teapod(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "Teapod";
        electricity = new Electricity(19);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }


}
