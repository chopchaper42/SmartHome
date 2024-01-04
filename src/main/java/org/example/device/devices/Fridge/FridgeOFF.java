package org.example.device.devices.Fridge;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class FridgeOFF extends DeviceState {
    public FridgeOFF(Device device) {
        super(device);
    }

    @Override
    public void use() {}
}
