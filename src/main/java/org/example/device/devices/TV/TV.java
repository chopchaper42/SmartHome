package org.example.device.devices.TV;

import org.example.device.Device;

public class TV extends Device {

    private final double CONSUMPTION = 25D;

    public TV() {
        super(10d);
        state = new TVOFF(this);
    }

    @Override
    public void off() {
        state = new TVOFF(this);
    }

    @Override
    public void on() {
        state = new TVON(this);
    }
}
