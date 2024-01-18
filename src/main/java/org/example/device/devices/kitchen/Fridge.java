package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.device.electricity.Electricity;
import org.example.device.electricity.ElectricityRecord;
import org.example.device.state_pattern.OffState;
import org.example.device.state_pattern.UsingState;
import org.example.house.Room;

/**
 * Fridge class - kitchen device
 */
public class Fridge extends Device {

    public Fridge(Room currentRoom) {
        super(currentRoom);
        nameOfDevice = "Fridge";
        electricity = new Electricity(26);
        electricityRecord = new ElectricityRecord();
        stateOfDevice = new UsingState(this);
    }


}
