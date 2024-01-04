package org.example.device.devices.Lamp;

import org.example.device.Device;

public class Lamp extends Device {
    public Lamp() {
        super(3d);
        state = new LampOFF(this);
    }

    public boolean isOn() { return state instanceof LampON; }
    @Override
    public void off() {
        state = new LampOFF(this);
    }

    @Override
    public void on() {
        state = new LampON(this);
    }
}
