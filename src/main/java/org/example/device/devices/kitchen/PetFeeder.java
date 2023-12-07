package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.Room;

public class PetFeeder extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 5;
    private static final int brokenElectricityWasting = 7;
    private static final int idleElectricityWasting = 1;
    //****************************
    public PetFeeder(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
