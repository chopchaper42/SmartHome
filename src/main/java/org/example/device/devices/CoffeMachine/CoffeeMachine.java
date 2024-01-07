package org.example.device.devices.CoffeMachine;

import org.example.device.Device;

public class CoffeeMachine extends Device {
    /**
     * Creates a coffee machine
     */
    public CoffeeMachine() {
        super(5d);
    }
    @Override
    public String getDocumentation() {
        return "Coffee Machine documentation";
    }
}
