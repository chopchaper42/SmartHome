package org.example.device.devices.CoffeMachine;

import org.example.device.Device;

public class CoffeeMachine extends Device {
    public CoffeeMachine() {
        super();
        state = new CoffeeMachineOFF(this);
    }

    @Override
    public void off() {
        state = new CoffeeMachineOFF(this);
    }

    @Override
    public void on() {
        state = new CoffeeMachineON(this);
    }
}
