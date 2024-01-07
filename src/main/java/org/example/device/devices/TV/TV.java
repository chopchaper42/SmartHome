package org.example.device.devices.TV;

import org.example.device.Device;
import org.example.device.state.StateOFF;

public class TV extends Device {
    /**
     * Creates a TV
     */
    public TV() {
        super(10d);
        state = new StateOFF(this);
    }

    @Override
    public String getDocumentation() {
        return "TV documentation";
    }
}
