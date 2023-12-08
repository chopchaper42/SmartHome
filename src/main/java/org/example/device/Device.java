package org.example.device;

import org.example.device.state_pattern.DeviceState;
import org.example.device.state_pattern.OffState;
import org.example.device.state_pattern.OnState;
import org.example.house.Room;

public abstract class Device {

    //private final DeviceTypes type;
    private final Room currentRoom;

    //electricity wasting
    private final int onElectricityWasting;
    private final int offElectricityWasting;

    private final int brokenElectricityWasting;
    //**************************************

    //State pattern
    private DeviceState stateOfDevice;
    //private Device currentState = new OffState(this); default state???
    //*******************************

    protected Device(Room currentRoom, int onElectricityWasting, int offElectricityWasting, int brokenElectricityWasting) {
        this.currentRoom = currentRoom;
        this.onElectricityWasting = onElectricityWasting;
        this.offElectricityWasting = offElectricityWasting;
        this.brokenElectricityWasting = brokenElectricityWasting;
    }

    //GETTERS

    public int getOnElectricityWasting() {
        return onElectricityWasting;
    }

    public int getOffElectricityWasting() {
        return offElectricityWasting;
    }

    public int getBrokenElectricityWasting() {
        return brokenElectricityWasting;
    }

    //SETTERS

    public void setStateOfDevice(DeviceState stateOfDevice) {
        this.stateOfDevice = stateOfDevice;
    }
    //***********************************

    //State pattern sketches
    public String turnOn() {
        return "Device IS ON ( ͡° ͜ʖ ͡°)";
    }
    public String turnOff() {
        return "Device is OFF (っ-̶●̃益●̶̃)っ";
    }
}
