package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.Room;

public class TV extends Device {
    //electricity wasting
    private static final int onElectricityWasting = 10;
    private static final int offElectricityWasting = 20;
    private static final int brokenElectricityWasting = 5;
    //****************************
    public TV(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
