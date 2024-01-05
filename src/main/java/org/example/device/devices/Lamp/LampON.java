package org.example.device.devices.Lamp;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class LampON extends DeviceState {
    private final double CONSUMPTION = 5d;
    public LampON(Device device) {
        super(device);
    }

    @Override
    public void use() {
        device.consumeElectricity();
    }
}
