package org.example.device;

import org.example.device.devices.Lamp.Lamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeviceTest {

    Device device = new Lamp();
    @Test
    void consumePower() {
        Assertions.assertEquals(0, device.getConsumedElectricity());
        Assertions.assertTrue(device.isOff());

        device.on();

        Assertions.assertTrue(device.isOn());

        device.use();

        Assertions.assertEquals(5, device.getConsumedElectricity());
    }

    @Test
    void isOn() {
    }

    @Test
    void isOff() {
    }

    @Test
    void use() {
    }

    @Test
    void off() {
    }

    @Test
    void on() {
    }
}