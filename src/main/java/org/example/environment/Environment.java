package org.example.environment;

import lombok.*;
import org.example.environment.airQuality.AirQuality;
import org.example.environment.airTemperature.AirTemperature;
import org.example.environment.atmosphericPressure.AtmosphericPressure;
import org.example.environment.windSpeed.WindSpeed;
import org.example.sensor.Sensor;
import org.example.sensor.TemperatureSensor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    private List<Sensor> subscribers = new LinkedList<>();
    private AirTemperature airTemperature;
    private WindSpeed windSpeed;
    private AirQuality airQuality;
    private AtmosphericPressure atmosphericPressure;

    public void update() {
        airTemperature.update();
//        windSpeed.update();
        airQuality.update();
//        atmosphericPressure.update();

        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Sensor s : subscribers) {
            if (s instanceof TemperatureSensor)
                s.reactOnChange(airTemperature.getTemperature());
        }
    }

    public void addSubscriber(Sensor sensor) {
        subscribers.add(sensor);
    }
}
