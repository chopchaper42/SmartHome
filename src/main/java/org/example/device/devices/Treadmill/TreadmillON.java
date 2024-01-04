package org.example.device.devices.Treadmill;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class TreadmillON extends DeviceState {
    private final double CONSUMPTION = 20d;
    public TreadmillON(Device device) {
        super(device);
    }

    @Override
    public void use() {
        device.consumeElectricity(CONSUMPTION);
    }
}
