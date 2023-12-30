package org.example.device.device_factory;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.KitchenDeviceTypes;
import org.example.device.devices.kitchen.ElectricStove;
import org.example.device.devices.kitchen.Fridge;
import org.example.device.devices.kitchen.PetFeeder;
import org.example.device.devices.kitchen.Teapod;
import org.example.house.room.Room;

public class KitchenDeviceCreator extends DeviceFactory<KitchenDeviceTypes>{
    //redo later
    @Override
    public Device createDevice(Room room, DeviceTypes type, KitchenDeviceTypes concreteDevice){
            Device device = switch (concreteDevice) {
                case TEAPOD -> new Teapod(room);
                case FRIDGE -> new Fridge(room);
                case ELECTRIC_STOVE -> new ElectricStove(room);
                case PET_FEEDER -> new PetFeeder(room);
                default -> throw new IllegalArgumentException("Unknown Construction Device Type");
            };
        return device;
    }
}
