package org.example.device;

public enum EntertainmentDeviceTypes {
    TV(DeviceTypes.ENTERTAINMENT_DEVICE),
    MOBILE(DeviceTypes.ENTERTAINMENT_DEVICE),
    SMART_WATCH(DeviceTypes.ENTERTAINMENT_DEVICE),
    CD_PLAYER(DeviceTypes.ENTERTAINMENT_DEVICE),
    COMPUTER(DeviceTypes.ENTERTAINMENT_DEVICE);

    private final DeviceTypes type;

    EntertainmentDeviceTypes(DeviceTypes type) {
        this.type = type;
    }
}
