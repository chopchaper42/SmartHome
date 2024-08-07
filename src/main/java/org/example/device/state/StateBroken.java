package org.example.device.state;

import org.example.device.Device;

public class StateBroken extends DeviceState {
    public StateBroken(Device device) {
        super(device);
    }

    /**
     * Prints to the console a message "The device is broken!"
     */
    @Override
    public void use() {
        System.out.println("The device is broken!");
    }

    /**
     * Repairs the device
     */
    @Override
    public void repair() {
        System.out.println("Reading documentation: " + device.getDocumentation());
        device.setState(new StateOFF(device));
        System.out.println(device.getId() + " is now working!");
    }
}
