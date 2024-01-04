package org.example.device.devices.Computer;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class ComputerOFF extends DeviceState {
    public ComputerOFF(Device device) {
        super(device);
    }
    @Override
    public void use() {}
}
