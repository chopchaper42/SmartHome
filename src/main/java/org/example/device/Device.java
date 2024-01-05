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
    protected boolean isAlwaysOn = false;

    protected Device(double consumption) {
        this.id = UUID.randomUUID().toString();
        electricityConsumption = consumption;
    }

//    public void consumeElectricity() { state.use(); }

    public void use() {
        if (!isON())
            on();

        state.use();

        if (!isAlwaysOn())
            off();
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
    public void setAlwaysOn(boolean b) {
        isAlwaysOn = b;
    }

    public boolean isAlwaysOn() {
        return isAlwaysOn;
    }

}
