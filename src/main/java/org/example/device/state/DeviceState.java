package org.example.device.state;

import org.example.device.Device;

public abstract class DeviceState {
    protected Device device;
    public DeviceState(Device device){
        this.device = device;
    }
    public abstract void use();
    public void repair() {
        System.out.println("No need to repair the device");
    }

}
