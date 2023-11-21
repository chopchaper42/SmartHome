package org.example.environment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.environment.airTemperature.AirTemperature;
import org.example.sensor.Sensor;

import java.util.List;

@AllArgsConstructor
@Getter
public class Environment {
    private List<Sensor> subscribers;
    private AirTemperature airTemperature;
    private WindSpeed windSpeed;
    private AirQuality airQuality;
    private AtmosphericPressure atmosphericPressure;

    public void update() {
        airTemperature.update();
        /*windSpeed.update();
        airQuality.update();
        atmosphericPressure.update();*/
    }

    public void notifySubscribers() {

    }



    public void addSubscriber(Sensor sensor) {
        subscribers.add(sensor);
    }
}
