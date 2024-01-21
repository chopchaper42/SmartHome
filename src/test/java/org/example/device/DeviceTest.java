package org.example.device;

import org.example.device.devices.Lamp.Lamp;
import org.example.device.state.StateBroken;
import org.example.device.state.StateON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DeviceTest {

    Device device = new Lamp();
    @Test
    void consumePower() {
        Assertions.assertEquals(0, device.getConsumedElectricity());
        Assertions.assertFalse(device.isON());

        device.on();

        Assertions.assertTrue(device.isON());

        device.update();

        Assertions.assertEquals(5, device.getConsumedElectricity());
    }

    @Test
    void updateWhenStateOFFDoesNothing() {
        Assertions.assertEquals(0, device.getConsumedElectricity());
        Assertions.assertFalse(device.isON());

        device.update();

        Assertions.assertEquals(0, device.getConsumedElectricity());
    }
    @Test
    void updateWhenStateBrokenPrintsMessage() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Assertions.assertEquals(0, device.getConsumedElectricity());
        device.setState(new StateBroken(device));

        device.update();

        Assertions.assertEquals(0, device.getConsumedElectricity());
        Assertions.assertTrue(out.toString().contains("The device is broken!"));
    }

    @Test
    void repairDeviceWhenIsON() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        device.setState(new StateON(device));

        device.repair();

        Assertions.assertTrue(device.isON());
        Assertions.assertTrue(out.toString().contains("No need to repair the device"));
    }

    @Test
    void repairDeviceWhenIsBroken() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        device.setState(new StateBroken(device));

        device.repair();

        Assertions.assertFalse(device.isBroken());
        Assertions.assertFalse(device.isON());
        Assertions.assertTrue(out.toString().contains(device.getId() + " is now working!"));
    }

    @Test
    void methodOnHasNoEffectIfDeviceIsBroken() {
        device.setState(new StateBroken(device));

        device.on();

        Assertions.assertTrue(device.isBroken());
    }

    @Test
    void methodOffHasNoEffectIfDeviceIsBroken() {
        device.setState(new StateBroken(device));

        device.off();

        Assertions.assertTrue(device.isBroken());
    }


}