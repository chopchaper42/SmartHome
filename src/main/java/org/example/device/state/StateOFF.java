package org.example.device.state;

import org.example.device.Device;

public class StateOFF extends DeviceState {
    public StateOFF(Device device) {
        super(device);
    }

    @Override
    public void use() {}
}
