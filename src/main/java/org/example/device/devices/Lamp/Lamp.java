package org.example.device.devices.Lamp;

import org.example.device.Device;

public class Lamp extends Device {
    public Lamp() {
        super();
        state = new LampOFF(this);
    }

    @Override
    public void off() {
        state = new LampOFF(this);
    }

    @Override
    public void on() {
        state = new LampON(this);
    }
}
