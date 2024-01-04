package org.example.device.devices.CoffeMachine;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class CoffeeMachineOFF extends DeviceState {

    public CoffeeMachineOFF(Device device) {
        super(device);
    }

    @Override
    public void use() {}
}
