package org.example.device.devices.AudioPlayer;

import org.example.device.Device;
import org.example.device.state.StateOFF;
import org.example.device.state.StateON;

public class AudioPlayer extends Device {
    protected AudioPlayer() {
        super(7d);
    }

    @Override
    public String getDocumentation() {
        return "Audio Player documentation";
    }
}
