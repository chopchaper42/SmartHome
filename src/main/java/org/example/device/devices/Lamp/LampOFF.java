package org.example.device.devices.Lamp;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class LampOFF extends DeviceState {
    public LampOFF(Device device) {
        super(device);
    }

    @Override
    public void use() {}
}
