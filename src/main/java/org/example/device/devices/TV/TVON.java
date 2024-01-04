package org.example.device.devices.TV;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class TVON extends DeviceState {
    private final double CONSUMPTION = 15d;
    public TVON(Device device) {
        super(device);
    }

    @Override
    public void use() {
        device.consumeElectricity(CONSUMPTION);
    }
}
