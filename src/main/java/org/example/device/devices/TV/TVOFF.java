package org.example.device.devices.TV;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class TVOFF extends DeviceState {
    public TVOFF(Device device) {
        super(device);
    }

    @Override
    public void use() {}
}
