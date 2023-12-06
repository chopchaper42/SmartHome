package org.example.device.device_factory;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.KitchenDeviceTypes;
import org.example.device.devices.entertainment.*;
import org.example.device.devices.kitchen.ElectricStove;
import org.example.device.devices.kitchen.Fridge;
import org.example.device.devices.kitchen.PetFeeder;
import org.example.device.devices.kitchen.Teapod;
import org.example.house.Room;

import static org.example.device.DeviceTypes.ENTERTAINMENT_DEVICE;
import static org.example.device.DeviceTypes.KITCHEN_DEVICE;

public class KitchenDeviceCreator extends DeviceFactory{
    //redo later
    @Override
    public Device createDevice(Room room, DeviceTypes type, KitchenDeviceTypes concreteDevice){
        if (type == KITCHEN_DEVICE) {
            Device device = switch (concreteDevice) {
                case TEAPOD: new Teapod();
                case FRIDGE: new Fridge();
                case ELECTRIC_STOVE: new ElectricStove();
                case PET_FEEDER: new PetFeeder();
            }
        }
        return device;
    }
}
