package org.example.device.devices.Computer;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class ComputerON extends DeviceState {
    private final double CONSUMPTION = 20d;

    public ComputerON(Device device) {
        super(device);
    }

    @Override
    public void use() {
        device.consumeElectricity();
    }
}
