package org.example.device.device_factory;

import org.example.device.ConstructionDeviceTypes;
import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.devices.construction.AutomaticDoor;
import org.example.device.devices.construction.AutomaticWindow;
import org.example.house.Room;

import static org.example.device.ConstructionDeviceTypes.AUTOMATIC_DOOR;
import static org.example.device.DeviceTypes.CONSTRUCTION_DEVICE;

public class ConstructionDeviceCreator extends DeviceFactory{
    //redo later

    @Override
    public Device createDevice(Room room, DeviceTypes type, ConstructionDeviceTypes concreteDevice){
        if (type == CONSTRUCTION_DEVICE) {
            Device device = switch (concreteDevice) {
                case AUTOMATIC_DOOR: new AutomaticDoor();
                case AUTOMATIC_WINDOW: new AutomaticWindow();
            }
        }
        return device;
    }
}
