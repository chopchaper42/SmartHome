package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.Room;

public class Teapod extends Device {
    //electricity wasting
    private static final int usualElectricityWasting = 10;
    private static final int brokenElectricityWasting = 2;
    private static final int idleElectricityWasting = 1;
    //****************************
    public Teapod(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
