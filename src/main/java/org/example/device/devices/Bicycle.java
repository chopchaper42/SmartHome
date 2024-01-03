package org.example.device.devices;

import org.example.device.Device;

public class Bicycle extends Device {
    private final double CONSUMPTION = 20D;
    @Override
    public void use() {
        consumedElectricity += CONSUMPTION;
    }
}
