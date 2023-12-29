package org.example.device.state_pattern;

import org.example.device.Device;

public abstract class DeviceState { //or interface?
    protected Device device;
    public DeviceState(Device device){
        this.device = device;
    }


    //public abstract void onHome();
    public abstract String onOffOn();
    public abstract void usingElectricity();

}
