package org.example.device.device_factory;

import org.example.device.ConstructionDeviceTypes;
import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.devices.construction.AutomaticDoor;
import org.example.device.devices.construction.AutomaticWindow;
import org.example.device.devices.construction.ConstructionDeviceInterface;
import org.example.house.Room;

import java.util.ArrayList;
import java.util.List;


public class ConstructionDeviceCreator extends DeviceFactory<ConstructionDeviceTypes>{
    private static ConstructionDeviceCreator instance = null;
    private final List<ConstructionDeviceInterface> construction_devices = new ArrayList<>();

    /**
     * Private singleton constructor
     */
    private ConstructionDeviceCreator(){}

    /**
     * Method for getting ConstructionDeviceCreator instance - Singleton pattern
     * @return instance of ConstructionDeviceCreator
     */
    public static ConstructionDeviceCreator getInstance() {
        if (instance == null) { instance = new ConstructionDeviceCreator();}
        return instance;
    }


    @Override
    public Device createDevice(Room room,  ConstructionDeviceTypes concreteDevice){
            Device device = switch (concreteDevice) {
                case AUTOMATIC_DOOR -> new AutomaticDoor(room);
                case AUTOMATIC_WINDOW -> new AutomaticWindow(room);
                default -> throw new IllegalArgumentException("Unknown Construction Device Type");
        };
        return device;
    }

    public List<ConstructionDeviceInterface> getDevices(){
        return construction_devices;
    }
}
