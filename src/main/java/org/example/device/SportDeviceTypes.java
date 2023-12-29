package org.example.device;

public enum SportDeviceTypes {
    RUNNING_PATH(DeviceTypes.SPORT_DEVICE),
    ORBITEK(DeviceTypes.SPORT_DEVICE);

    private final DeviceTypes type;

    SportDeviceTypes(DeviceTypes type) {
        this.type = type;
    }
}
