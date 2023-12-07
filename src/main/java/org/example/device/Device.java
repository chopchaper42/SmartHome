package org.example.device;

import org.example.house.Room;

public abstract class Device {

    //private final DeviceTypes type;
    private final Room currentRoom;

    //electricity wasting
    private final int usualElectricityWasting;
    private final int brokenElectricityWasting;


    private final int idleElectricityWasting;

    private int electricity = 0;


    protected Device(Room currentRoom, int usualElectricityWasting, int brokenElectricityWasting, int idleElectricityWasting) {
        this.currentRoom = currentRoom;
        this.usualElectricityWasting = usualElectricityWasting;
        this.brokenElectricityWasting = brokenElectricityWasting;
        this.idleElectricityWasting = idleElectricityWasting;
    }

    //GETTERS & SETTERS
    public int getUsualElectricityWasting() {
        return usualElectricityWasting;
    }

    public int getBrokenElectricityWasting() {
        return brokenElectricityWasting;
    }

    public int getIdleElectricityWasting() {
        return idleElectricityWasting;
    }
}
