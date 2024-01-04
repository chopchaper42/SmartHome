package org.example.device.devices.Bicycle;

import org.example.device.Device;

public class Bicycle extends Device {
    public Bicycle() {
        super();
        state = new BicycleOFF(this);
    }

    @Override
    public void use() {
        state.use();
    }

    @Override
    public void off() {
        state = new BicycleOFF(this);
    }

    @Override
    public void on() {
        state = new BicycleON(this);
    }
}
