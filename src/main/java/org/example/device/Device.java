package org.example.device;

import lombok.Getter;
import lombok.Setter;
import org.example.SmartHouse;
import org.example.Task;
import org.example.TaskSource;
import org.example.device.state.DeviceState;
import org.example.device.state.StateBroken;
import org.example.device.state.StateOFF;
import org.example.device.state.StateON;

import java.util.Random;
import java.util.UUID;

public abstract class Device implements TaskSource {
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
    @Getter @Setter
    protected boolean isOccupied = false;

    protected Device(double consumption) {
        this.id = UUID.randomUUID().toString();
        this.CONSUMPTION = consumption;
        state = new StateOFF(this);
    }

    /**
     * Increases consumed electricity
     * @param consumption a value to increase by
     */
    public void consumeElectricity(double consumption) { this.consumedElectricity += consumption; }

    /**
     * Consumes electricity. May 5% chance to get broken.
     */
    public void update() {
        if (state instanceof StateON && new Random().nextInt(100) < 5) {
            setState(new StateBroken(this));
            SmartHouse.instance().assignTask(this, Task.Type.REPAIR);
            System.out.println(getId() + " is broken. Need to repair.");
            return;
        }
        state.use();
    }

    /**
     * Turns the device off
     */
    public void off() {
        if (!isBroken())
            state = new StateOFF(this);
    }

    /**
     * Turns the device on
     */
    public void on() {
        if (!isBroken())
            state = new StateON(this);
    }

    /**
     * @return device id
     */
    @Override
    public String toString() {
        return id;
    }

    /**
     * Returns the documentation
     * @return device documentation
     */
    public abstract String getDocumentation();

    /**
     * @return true if the device is on, false otherwise
     */
    public boolean isON() {
        return state instanceof StateON;
    }

    /**
     * @return true if the device is broken, false otherwise
     */
    public boolean isBroken() {
        return state instanceof StateBroken;
    }

    /**
     * Repairs the device if is broken
     */
    public void repair() {
        state.repair();
    }

}
