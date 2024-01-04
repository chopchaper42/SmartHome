package org.example.device.devices.CoffeMachine;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class CoffeeMachineON extends DeviceState {
    private final double CONSUMPTION = 5d;

    public CoffeeMachineON(Device device) {
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
