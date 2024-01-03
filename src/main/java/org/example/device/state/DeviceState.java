package org.example.device.state;

import org.example.device.Device;

public abstract class DeviceState {
    protected Device device;
    public DeviceState(Device device){
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void use();

}
