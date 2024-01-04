package org.example.device;

import org.example.device.devices.Lamp.Lamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeviceTest {

    Device device = new Lamp();
    @Test
    void consumePower() {
        Assertions.assertEquals(0, device.consumedElectricity());
        Assertions.assertFalse(device.isON());

        device.on();

        Assertions.assertTrue(device.isON());

        device.use();

        Assertions.assertEquals(5, device.consumedElectricity());
    }
}