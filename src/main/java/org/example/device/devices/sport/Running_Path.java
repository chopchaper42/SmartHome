package org.example.device.devices.sport;

import org.example.device.Device;
import org.example.house.Room;

public class Running_Path extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 15;
    private static final int brokenElectricityWasting = 23;
    private static final int idleElectricityWasting = 9;
    //****************************
    public Running_Path(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
