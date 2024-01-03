package org.example.device.devices;

import org.example.device.Device;

public class Lamp extends Device {

    private final double CONSUMPTION = 5D;
    @Override
    public void use() {
        consumedElectricity += CONSUMPTION;
    }
}
