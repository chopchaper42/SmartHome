package org.example.device.devices.entertainment;

import org.example.device.Device;
import org.example.house.room.Room;

public class Mobile extends Device {

    //electricity wasting
    //CHANGE LATER TO A BATTERY, NOT ELECTRICITY
    private static final int onElectricityWasting = 10;
    private static final int offElectricityWasting = 20;
    private static final int brokenElectricityWasting = 5;
    //****************************
    public Mobile(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }

}
