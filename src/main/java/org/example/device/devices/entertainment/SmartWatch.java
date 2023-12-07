package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.Room;

public class SmartWatch extends Device {
    //electricity wasting
    //CHANGE LATER TO THE BATTERY, NOT ELECTRICITY
    private static final int usualElectricityWasting = 7;
    private static final int brokenElectricityWasting = 20;
    private static final int idleElectricityWasting = 5;
    //****************************
    public SmartWatch(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
