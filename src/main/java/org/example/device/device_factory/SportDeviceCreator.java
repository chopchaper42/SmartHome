package org.example.device.device_factory;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.SportDeviceTypes;
import org.example.device.devices.entertainment.*;
import org.example.device.devices.sport.Orbitek;
import org.example.device.devices.sport.Running_Path;
import org.example.house.Room;

import static org.example.device.DeviceTypes.ENTERTAINMENT_DEVICE;
import static org.example.device.DeviceTypes.SPORT_DEVICE;

public class SportDeviceCreator extends DeviceFactory {
    //redo later

    @Override
    public Device createDevice(Room room, DeviceTypes type, SportDeviceTypes concreteDevice){
        if (type == SPORT_DEVICE) {
            Device device = switch (concreteDevice) {
                case RUNNING_PATH: new Running_Path();
                case ORBITEK: new Orbitek();
            }
        }
        return device;
    }
}
