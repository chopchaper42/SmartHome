package org.example.device.devices.Lamp;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class LampOFF extends DeviceState {
    private final double CONSUMPTION = 0;

    public LampOFF(Device device) {
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
