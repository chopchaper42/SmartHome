package org.example.device.devices.Fridge;

import org.example.device.Device;

public class Fridge extends Device {

    public Fridge() {
        super(10d);
        state = new FridgeON(this);
        setAlwaysOn(true);
    }
    @Override
    public void use() {
        state.use();
    }

    @Override
    public void off() {
        state = new FridgeOFF(this);
    }

    @Override
    public void on() {
        state = new FridgeON(this);
    }
}
