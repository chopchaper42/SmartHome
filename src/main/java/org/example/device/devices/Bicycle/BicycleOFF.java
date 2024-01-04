package org.example.device.devices.Bicycle;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class BicycleOFF extends DeviceState {

    public BicycleOFF(Device device) {
        super(device);
    }
    @Override
    public void use() {}
}
