package org.example.house;

import lombok.Builder;
import org.example.device.Device;
import org.example.environment.Environment;
import org.example.sensor.*;

import java.util.List;

@Builder
public class HouseControlSystem {
    private TemperatureSensor temperatureSensor;
    private WindSensor windSensor;
    private AirQualitySensor airQualitySensor;
    private AtmosphericPressureSensor atmosphericPressureSensor;
    private List<Device> devices;
    private AlertSystem alertSystem;
    private Environment environment;
}
