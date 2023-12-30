package org.example.device.devices.kitchen;

import org.example.device.Device;
import org.example.house.room.Room;

public class PetFeeder extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 5;
    private static final int offElectricityWasting = 7;
    private static final int brokenElectricityWasting = 1;
    //****************************
    public PetFeeder(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
