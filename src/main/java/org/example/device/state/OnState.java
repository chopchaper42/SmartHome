package org.example.device.state;

import org.example.device.Device;

public class OnState extends DeviceState {
    public OnState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() { }

    @Override
    public void turnOff() {
        device.setState(new OffState(device));
    }

    @Override
    public void use() {

    }


}
