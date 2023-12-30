package org.example.device.device_factory;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.devices.entertainment.*;
import org.example.house.room.Room;

import org.example.device.EntertainmentDeviceTypes;

public class EntertainmentDeviceCreator extends DeviceFactory<EntertainmentDeviceTypes>{
    //redo later
    @Override
    public Device createDevice(Room room, DeviceTypes type, EntertainmentDeviceTypes concreteDevice){
            Device device = switch (concreteDevice) {
                case TV -> new TV(room);
                case MOBILE -> new Mobile(room);
                case SMART_WATCH -> new SmartWatch(room);
                case CD_PLAYER -> new CdPlayer(room);
                case COMPUTER -> new Computer(room);
                default -> throw new IllegalArgumentException("Unknown Construction Device Type");
            };
        return device;
    }
}
