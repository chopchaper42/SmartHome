package org.example.device.devices.Treadmill;

import org.example.device.Device;
import org.example.device.state.StateOFF;

public class Treadmill extends Device {
    /**
     * Creates a treadmill
     */
    public Treadmill() {
        super(10d);
        state = new StateOFF(this);
    }

    @Override
    public String getDocumentation() {
        return "Treadmill documentation";
    }
}
