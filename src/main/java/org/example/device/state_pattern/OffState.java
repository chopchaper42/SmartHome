package org.example.device.state_pattern;

import org.example.device.Device;

public class OffState extends DeviceState{
    public OffState(Device device) {
        super(device);
    }

    @Override
    public String onOffOn() {
        device.setStateOfDevice(new OnState(device));
        return device.turnOn();
    }

    @Override
    public void usingElectricity() {

    }


}
