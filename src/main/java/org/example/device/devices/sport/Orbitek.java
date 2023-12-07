package org.example.device.devices.sport;

import org.example.device.Device;
import org.example.house.Room;

public class Orbitek extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 17;
    private static final int brokenElectricityWasting = 20;
    private static final int idleElectricityWasting = 7;
    //****************************
    public Orbitek(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
