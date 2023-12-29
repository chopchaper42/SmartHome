package org.example.device.devices.sport;

import org.example.device.Device;
import org.example.house.Room;

public class Orbitek extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 17;
    private static final int offElectricityWasting = 20;
    private static final int brokenElectricityWasting = 7;
    //****************************
    public Orbitek(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
