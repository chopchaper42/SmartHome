package org.example.device;

public enum ConstructionDeviceTypes {
    AUTOMATIC_DOOR(DeviceTypes.CONSTRUCTION_DEVICE),
    AUTOMATIC_WINDOW(DeviceTypes.CONSTRUCTION_DEVICE);

    private final DeviceTypes type;
    ConstructionDeviceTypes(DeviceTypes type) {
        this.type = type;
    }
}
