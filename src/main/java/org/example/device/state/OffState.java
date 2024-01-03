package org.example.device.state;

import org.example.device.Device;

public class OffState extends DeviceState {
    public OffState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }
    @Override
    public void turnOff() {}

    @Override
    public void use() {
        device.
    }

}
