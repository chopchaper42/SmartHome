package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.room.Room;

public class SmartWatch extends Device {
    //electricity wasting
    //CHANGE LATER TO THE BATTERY, NOT ELECTRICITY
    private static final int onElectricityWasting = 7;
    private static final int offElectricityWasting = 20;
    private static final int brokenElectricityWasting = 5;
    //****************************
    public SmartWatch(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
