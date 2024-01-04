package org.example.device.devices.Treadmill;

import org.example.device.Device;
import org.example.device.devices.Lamp.LampOFF;
import org.example.device.devices.Lamp.LampON;

public class Treadmill extends Device {
    public Treadmill() {
        super(10d);
        state = new TreadmillOFF(this);
    }

    public boolean isOn() { return state instanceof TreadmillON; }
    @Override
    public void off() {
        state = new TreadmillOFF(this);
    }

    @Override
    public void on() {
        state = new TreadmillON(this);
    }
}
