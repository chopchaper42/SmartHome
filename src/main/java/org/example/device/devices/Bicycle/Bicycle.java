package org.example.device.devices.Bicycle;

import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.state.StateOFF;

public class Bicycle extends Device {

    /**
     * Creates a bicycle
     */
    public Bicycle() {
        super(10d);
    }

    @Override
    public String getDocumentation() {
        return "Bicycle documentation";
    }
}
