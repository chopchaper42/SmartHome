package org.example.device.device_factory;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.house.Room;

public abstract class DeviceFactory {
    private String concreteDevice;
    public abstract Device createDevice(Room room, DeviceTypes type, String concreteDevice);


}
