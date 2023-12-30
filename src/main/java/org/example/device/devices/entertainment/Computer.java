package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.room.Room;

public class Computer extends Device {
    //electricity wasting
    private static final int onElectricityWasting = 8;
    private static final int offElectricityWasting = 15;
    private static final int brokenElectricityWasting = 1;
    //****************************
    public Computer(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
