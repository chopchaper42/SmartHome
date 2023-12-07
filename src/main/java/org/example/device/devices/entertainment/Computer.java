package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.Room;

public class Computer extends Device {
    //electricity wasting
    private static final int usualElectricityWasting = 8;
    private static final int brokenElectricityWasting = 15;
    private static final int idleElectricityWasting = 1;
    //****************************
    public Computer(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
