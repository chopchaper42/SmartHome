package org.example.device.devices.Fridge;

import org.example.SmartHouse;
import org.example.device.Device;
import org.example.device.state.StateON;

import java.util.List;

public class Fridge extends Device {

    public Fridge() {
        super(10d);
        state = new StateON(this);
        setAlwaysOn(true);
    }

    @Override
    public String getDocumentation() {
        return "Fridge documentation";
    }
}
