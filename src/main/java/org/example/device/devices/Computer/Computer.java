package org.example.device.devices.Computer;

import org.example.device.Device;
import org.example.device.state.DeviceState;

public class Computer extends Device {

    public Computer() {
        super(15d);
    }
    @Override
    public String getDocumentation() {
        return "Computer documentation";
    }
}
