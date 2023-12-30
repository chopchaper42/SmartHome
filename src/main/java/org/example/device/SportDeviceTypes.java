package org.example.device;

public enum SportDeviceTypes {
    TREADMILL(DeviceTypes.SPORT_DEVICE),
    ORBITEK(DeviceTypes.SPORT_DEVICE);

    private final DeviceTypes type;

    SportDeviceTypes(DeviceTypes type) {
        this.type = type;
    }
}
