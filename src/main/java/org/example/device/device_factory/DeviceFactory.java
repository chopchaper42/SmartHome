package org.example.device.device_factory;

import org.example.device.Device;

public class DeviceFactory {

    private static DeviceFactory instance;

    private DeviceFactory() {}

    public static DeviceFactory getInstance() {
        if (instance == null)
            instance = new DeviceFactory();

        return instance;
    }

    public static <T extends Device> T createDevice(Class<T> clazz) {
        T device;
        try {
            // TODO: there is no default constructor in Device;
            device = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return device;
    }
}
