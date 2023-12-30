package org.example.device.device_factory;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.house.room.Room;

public abstract class DeviceFactory<T> {
    //private concreteDevice;
    public abstract Device createDevice(Room room, DeviceTypes type, T concreteDevice);
}
