package org.example.device;

import lombok.Getter;
import lombok.Setter;
import org.example.device.state.DeviceState;
import org.example.device.state.StateON;

import java.util.UUID;

public abstract class Device {
    protected DeviceState state;
    protected double consumedElectricity;
    private double electricityConsumption;
    @Setter
    private String id;

    protected Device(double consumption) {
        this.id = UUID.randomUUID().toString();
        electricityConsumption = consumption;
    }

    public void consumeElectricity(double d) { consumedElectricity += d; }

    public void use() {
        state.use();
    }

    public abstract void off();
    public abstract void on();

    @Override
    public String toString() {
        return id;
        /*String[] tokens = super.toString().split("\\.");
        return tokens[tokens.length - 1];*/
    }

    public boolean isON() { return state instanceof StateON; }

    public double consumedElectricity() {
        return consumedElectricity;
    }

    public double electricityConsumption() {
        return electricityConsumption;
    }

    public String id() {
        return id;
    }

}
