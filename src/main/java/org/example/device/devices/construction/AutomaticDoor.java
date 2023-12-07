package org.example.device.devices.construction;

import org.example.device.Device;
import org.example.house.Room;

public class AutomaticDoor extends Device {

    //electricity wasting
    private static final int usualElectricityWasting = 2;
    private static final int brokenElectricityWasting = 5;
    private static final int idleElectricityWasting = 1;

    //*************
    private boolean opened;
    private boolean locked;

    public boolean isOpened() {
        return opened;
    }

    public boolean isLocked() {
        return opened;
    }

    //do later
    public void open() {

    }

    public void close() {

    }

    public void lock() {

    }

    public void unlock() {

    }

    public AutomaticDoor(Room room) {
        super(room, usualElectricityWasting, brokenElectricityWasting, idleElectricityWasting);
    }
}
