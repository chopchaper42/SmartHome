package org.example.device.devices.construction;

import org.example.device.Device;
import org.example.house.Room;

public class AutomaticDoor extends Device {

    //electricity wasting
    private static final int onElectricityWasting = 2;
    private static final int brokenElectricityWasting = 5;
    private static final int offElectricityWasting = 1;

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
        super(room, onElectricityWasting, offElectricityWasting, brokenElectricityWasting);
    }
}
