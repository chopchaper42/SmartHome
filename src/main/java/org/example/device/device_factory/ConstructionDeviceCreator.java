package org.example.device.device_factory;

import org.example.device.ConstructionDeviceTypes;
import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.devices.construction.AutomaticDoor;
import org.example.device.devices.construction.AutomaticWindow;
import org.example.house.Room;

import static org.example.device.ConstructionDeviceTypes.AUTOMATIC_DOOR;
import static org.example.device.DeviceTypes.CONSTRUCTION_DEVICE;

public class ConstructionDeviceCreator extends DeviceFactory<ConstructionDeviceTypes>{
    //redo later

    @Override
    public Device createDevice(Room room, DeviceTypes type, ConstructionDeviceTypes concreteDevice){
            Device device = switch (concreteDevice) {
                case AUTOMATIC_DOOR -> new AutomaticDoor(room);
                case AUTOMATIC_WINDOW -> new AutomaticWindow(room);
                default -> throw new IllegalArgumentException("Unknown Construction Device Type");

        };
        return device;
    }
}
