package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.room.Room;

public class ElectricStove extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 25;
    private static final int offElectricityWasting = 50;
    private static final int brokenElectricityWasting = 10;
    //****************************
    public ElectricStove(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
