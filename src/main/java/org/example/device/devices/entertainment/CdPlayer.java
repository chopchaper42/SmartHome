package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.Room;

public class CdPlayer extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 15;
    private static final int offElectricityWasting = 20;
    private static final int brokenElectricityWasting = 1;
    //****************************
    public CdPlayer(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
