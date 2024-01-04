package org.example.device.devices.Bicycle;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class BicycleOFF extends DeviceState {

    private final double CONSUMPTION = 0;

    public BicycleOFF(Device device) {
        super(device);
        state = State.OFF;
    }
    @Override
    public void turnOn() {
        device.on();
    }

    @Override
    public void turnOff() {}

    @Override
    public void use() {}
}
