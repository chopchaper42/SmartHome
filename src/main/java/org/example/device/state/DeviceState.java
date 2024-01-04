package org.example.device.state;

import org.example.device.Device;

public abstract class DeviceState {
    public enum State {
        ON,
        OFF
    }

    protected DeviceState.State state;
    protected Device device;
    public DeviceState(Device device){
        this.device = device;
    }
    public boolean isOn() { return state == State.ON; }
    public boolean isOff() { return state == State.OFF; }
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void use();

}
