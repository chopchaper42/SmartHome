package org.example.device.devices.Computer;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class Computer extends Device {

    public Computer() {
        super(10d);
        state = new ComputerOFF(this);
    }

    @Override
    public void off() {
        state = new ComputerOFF(this);
    }

    @Override
    public void on() {
        state = new ComputerON(this);
    }
}
