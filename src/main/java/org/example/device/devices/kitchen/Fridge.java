package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.Room;

public class Fridge extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 8;
    private static final int brokenElectricityWasting = 14;
    private static final int idleElectricityWasting = 5;
    //****************************
    public Fridge(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
