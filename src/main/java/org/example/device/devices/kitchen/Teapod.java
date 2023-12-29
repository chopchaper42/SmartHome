package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.Room;

public class Teapod extends Device {
    //electricity wasting
    private static final int onElectricityWasting = 10;
    private static final int offElectricityWasting = 2;
    private static final int brokenElectricityWasting = 1;
    //****************************
    public Teapod(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
