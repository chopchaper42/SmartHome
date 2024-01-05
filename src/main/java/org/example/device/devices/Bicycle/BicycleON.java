package org.example.device.devices.Bicycle;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class BicycleON extends DeviceState {

//    private final double CONSUMPTION = 10d;

    public BicycleON(Device device) {
        super(device);
    }
    @Override
    public void use() {
        device.consumeElectricity();
    }
}
