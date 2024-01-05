package org.example.device;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.SmartHouse;
import org.example.Task;
import org.example.device.state.DeviceState;
import org.example.device.state.StateBroken;
import org.example.device.state.StateOFF;
import org.example.device.state.StateON;

import java.util.Random;
import java.util.UUID;

public abstract class Device {
    @Getter
    private final double CONSUMPTION;
    @Setter
    protected DeviceState state;
    @Getter
    protected double consumedElectricity;
    @Getter @Setter
    private String id;
    @Getter @Setter
    protected boolean isAlwaysOn = false;

    protected Device(double consumption) {
        this.id = UUID.randomUUID().toString();
        this.CONSUMPTION = consumption;
        state = new StateOFF(this);
    }

    public void consumeElectricity(double consumption) { this.consumedElectricity += consumption; }

    public void use() {
        if (new Random().nextInt(100) == 1) {
            setState(new StateBroken(this));
            SmartHouse.instance().addTask(new Task(this, Task.Type.REPAIR));
            // save event
            System.out.println(getId() + " is broken. Need to repair.");
            return;
        }
        state.use();
    }

    public void off() {
        if (!isBroken())
            state = new StateOFF(this);
    }
    public void on() {
        if (!isBroken())
            state = new StateON(this);
    }

    @Override
    public String toString() {
        return id;
    }

    public abstract String getDocumentation();

    public boolean isON() {
        return state instanceof StateON;
    }

    public boolean isBroken() {
        return state instanceof StateBroken;
    }

    public void repair() {
        if (isBroken())
            state.repair();
    }

}
