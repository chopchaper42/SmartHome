package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.Room;

public class CdPlayer extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 15;
    private static final int brokenElectricityWasting = 20;
    private static final int idleElectricityWasting = 1;
    //****************************
    public CdPlayer(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
