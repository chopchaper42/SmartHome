package org.example.device.state;

import org.example.device.Device;

public class StateON extends DeviceState {
    public StateON(Device device) {
        super(device);
    }

    /**
     * Increases consumed electricity
     */
    @Override
    public void use() {
        device.consumeElectricity(device.getCONSUMPTION());
    }
}
