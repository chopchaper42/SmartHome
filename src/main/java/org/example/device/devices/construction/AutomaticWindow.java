package org.example.device.devices.construction;

import org.example.device.Device;
import org.example.house.Room;

public class AutomaticWindow extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 2;
    private static final int brokenElectricityWasting = 5;
    private static final int idleElectricityWasting = 1;

    //*************
    private boolean opened;

    public boolean isOpened() {
        return opened;
    }

    public AutomaticWindow(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }


}
