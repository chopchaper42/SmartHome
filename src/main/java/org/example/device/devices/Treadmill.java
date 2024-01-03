package org.example.device.devices;

import org.example.device.Device;

public class Treadmill extends Device {

    private final double CONSUMPTION = 15D;
    @Override
    public void use() {
        consumedElectricity += CONSUMPTION;
    }
}
