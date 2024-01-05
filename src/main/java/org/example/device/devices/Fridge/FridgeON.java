package org.example.device.devices.Fridge;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class FridgeON extends DeviceState {

    private final double CONSUMPTION = 10d;

    public FridgeON(Device device) {
        super(device);
    }

    @Override
    public void use() {
        device.consumeElectricity();
    }
}
