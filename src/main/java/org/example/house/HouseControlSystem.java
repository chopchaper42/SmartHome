package org.example.house;

import lombok.Builder;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.environment.Environment;
import org.example.house.alertSystem.AlertSystem;
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

    public void subscribeOnAlertSystem(Creature c) {
        alertSystem.subscribe(c);
    }

    private void alert() {
//        alertSystem
    }
}
