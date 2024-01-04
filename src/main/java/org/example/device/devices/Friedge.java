package org.example.device.devices;

import org.example.device.Device;

public class Friedge extends Device {

    private final double CONSUMPTION = 25D;
    @Override
    public void use() {
        consumedElectricity += CONSUMPTION;
    }

    @Override
    public void off() {

    }

    @Override
    public void on() {

    }
}
