package org.example.device.devices.construction;

import org.example.device.Device;
import org.example.house.Room;

public class AutomaticWindow extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 2;
    private static final int offElectricityWasting = 5;
    private static final int brokenElectricityWasting = 1;

    //*************
    private boolean opened;

    public boolean isOpened() {
        return opened;
    }

    public AutomaticWindow(Room room) {
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }


}
