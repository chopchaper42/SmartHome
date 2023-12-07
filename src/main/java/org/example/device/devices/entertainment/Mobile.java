package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.Room;

public class Mobile extends Device {

    //electricity wasting
    //CHANGE LATER TO A BATTERY, NOT ELECTRICITY
    private static final int usualElectricityWasting = 10;
    private static final int brokenElectricityWasting = 20;
    private static final int idleElectricityWasting = 5;
    //****************************
    public Mobile(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }

}
