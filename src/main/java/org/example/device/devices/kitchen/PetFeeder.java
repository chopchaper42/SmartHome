package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.house.Room;

/**
 * PetFeeder class - kitchen device
 */
public class PetFeeder extends Device {


    public PetFeeder(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "PetFeeder";
        electricity = new Electricity(10);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new OffState(this);
    }


}
