package org.example.device.state_pattern;

import org.example.device.Device;

public class BrokenState extends DeviceState {
    public BrokenState(Device device) {
        super(device);
    }

    @Override
    public String onOffOn() {
        //???
        return null;
    }

    @Override
    public void usingElectricity() {

    }


}
