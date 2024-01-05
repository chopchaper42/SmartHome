package org.example.device.devices.Lamp;

import org.example.device.Device;
import org.example.device.state.StateOFF;
import org.example.device.state.StateON;

public class Lamp extends Device {

    public Lamp() {
        super(3d);
        state = new StateOFF(this);
    }

    @Override
    public String getDocumentation() {
        return "Lamp documentation";
    }
}
