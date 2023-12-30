package org.example.device.devices.sport;

import org.example.device.Device;
import org.example.house.room.Room;

public class Running_Path extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 15;
    private static final int offElectricityWasting = 23;
    private static final int brokenElectricityWasting = 9;
    //****************************
    public Running_Path(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
