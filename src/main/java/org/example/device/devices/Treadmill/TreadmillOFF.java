package org.example.device.devices.Treadmill;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class TreadmillOFF extends DeviceState {
    public TreadmillOFF(Device device) {
        super(device);
    }

    @Override
    public void use() {}
}
