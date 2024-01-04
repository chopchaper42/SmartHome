package org.example.device.devices.Bicycle;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class BicycleON extends DeviceState {

    private final double CONSUMPTION = 10d;

    public BicycleON(Device device) {
        super(device);
        state = State.ON;
    }
    @Override
    public void turnOn() {}

    @Override
    public void turnOff() {
        device.off();
    }

    @Override
    public void use() {
        device.consumeElectricity(CONSUMPTION);
    }
}
