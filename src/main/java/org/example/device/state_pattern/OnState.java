package org.example.device.state_pattern;

import org.example.device.Device;

public class OnState extends DeviceState {
    public OnState(Device device) {
        super(device);
    }

    @Override
    public String onOffOn() {
        device.setStateOfDevice(new OffState(device));
        return device.turnOff();
    }


}
