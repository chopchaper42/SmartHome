package org.example.device.devices.CoffeMachine;

import org.example.device.Device;

public class CoffeeMachine extends Device {
    public CoffeeMachine() {
        super(5d);
    }
    @Override
    public String getDocumentation() {
        return "Coffee Machine documentation";
    }
}
