package org.example.device.device_factory;

import org.example.device.ConstructionDeviceTypes;
import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.devices.construction.AutomaticDoor;
import org.example.device.devices.construction.AutomaticWindow;
import org.example.device.devices.entertainment.*;
import org.example.house.Room;

import static org.example.device.DeviceTypes.CONSTRUCTION_DEVICE;
import static org.example.device.DeviceTypes.ENTERTAINMENT_DEVICE;
import org.example.device.EntertainmentDeviceTypes;

public class EntertainmentDeviceCreator extends DeviceFactory{
    //redo later
    @Override
    public Device createDevice(Room room, DeviceTypes type, EntertainmentDeviceTypes concreteDevice){
        if (type == ENTERTAINMENT_DEVICE) {
            Device device = switch (concreteDevice) {
                case TV: new TV();
                case MOBILE: new Mobile();
                case SMART_WATCH: new SmartWatch();
                case CD_PLAYER: new CdPlayer();
                case COMPUTER: new Computer();
            }
        }
        return device;
    }
}
