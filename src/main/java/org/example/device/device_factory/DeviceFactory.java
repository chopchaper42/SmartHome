package org.example.device.device_factory;

import org.example.IDGenerator;
import org.example.device.Device;

public class DeviceFactory {

    private static DeviceFactory instance;

    private DeviceFactory() {}

    public static DeviceFactory getInstance() {
        if (instance == null)
            instance = new DeviceFactory();

        return instance;
    }

    public <T extends Device> T createDevice(Class<T> clazz) {
        T device;
        try {
            device = clazz.getDeclaredConstructor().newInstance();
            device.setId(IDGenerator.getInstance().generateID(clazz));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return device;
    }
}
