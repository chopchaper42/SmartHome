package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.Room;

public class ElectricStove extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 25;
    private static final int brokenElectricityWasting = 50;
    private static final int idleElectricityWasting = 10;
    //****************************
    public ElectricStove(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
