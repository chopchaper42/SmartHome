package org.example.environment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.environment.airTemperature.AirTemperature;
import org.example.sensor.Sensor;
import org.example.sensor.TemperatureSensor;

import java.util.List;

@AllArgsConstructor
@Getter
public class Environment {
    private List<Sensor> subscribers;
    private AirTemperature airTemperature;
    /*private WindSpeed windSpeed;
    private AirQuality airQuality;
    private AtmosphericPressure atmosphericPressure;*/

    public void update() {
        airTemperature.update();
        /*windSpeed.update();
        airQuality.update();
        atmosphericPressure.update();*/
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
