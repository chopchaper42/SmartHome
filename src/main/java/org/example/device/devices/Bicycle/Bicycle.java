package org.example.device.devices.Bicycle;

import org.example.device.Device;
import org.example.device.state.StateOFF;

public class Bicycle extends Device {
    public Bicycle() {
        super(10d);
        state = new BicycleOFF(this);
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
