package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.room.Room;

public class Fridge extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 8;
    private static final int offElectricityWasting = 14;
    private static final int brokenElectricityWasting = 5;
    //****************************
    public Fridge(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
