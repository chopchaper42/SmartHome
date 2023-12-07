package org.example.device.state_pattern;

import org.example.device.Device;

public abstract class DeviceState {
    protected Device device;
    public DeviceState(Device device){
        this.device = device;
    }

    //void usingElectricity();


}
