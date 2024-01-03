package org.example.device;

import org.example.device.state.DeviceState;
import org.example.device.state.OffState;
import org.example.house.room.Room;

import java.util.UUID;

public abstract class Device {
    protected DeviceState state;
    protected double consumedElectricity;
    private String id;

    public Device() {
        this.id = UUID.randomUUID().toString();
    }

    public void setState(DeviceState state) {
        this.state = state;
    }

    public abstract void use();
}
