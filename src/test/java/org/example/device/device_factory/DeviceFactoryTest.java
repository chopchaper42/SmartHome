package org.example.device.device_factory;

import org.example.device.devices.Lamp.Lamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceFactoryTest {

    @Test
    void createDevice() {
        DeviceFactory factory = DeviceFactory.getInstance();

        Lamp lamp = factory.createDevice(Lamp.class);

        Assertions.assertEquals("Lamp#1", lamp.getId());
    }
}