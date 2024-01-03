package org.example.device.devices;

import org.example.device.Device;

public class TV extends Device {

    private final double CONSUMPTION = 25D;
    @Override
    public void use() {
        consumedElectricity += CONSUMPTION;
    }
}
