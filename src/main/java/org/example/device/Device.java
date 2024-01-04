package org.example.device;

import lombok.Getter;
import org.example.device.state.DeviceState;

import java.util.UUID;

public abstract class Device {
    protected DeviceState state;
    @Getter
    protected double consumedElectricity;
    @Getter
    private String id;

    public Device() {
        this.id = UUID.randomUUID().toString();
    }

    private void setState(DeviceState state) {
        this.state = state;
    }

    public void consumeElectricity(double d) { consumedElectricity += d; }

    public boolean isOn() {return state.isOn(); }
    public boolean isOff() {return state.isOff(); }

    public void use() {
        state.use();
    }

    public abstract void off();
    public abstract void on();

    @Override
    public String toString() {
        String[] tokens = super.toString().split("\\.");
        return tokens[tokens.length - 1];
    }
}
