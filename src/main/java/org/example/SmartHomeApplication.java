package org.example;

import org.example.environment.Environment;
import org.example.environment.airQuality.AirQuality;
import org.example.environment.airTemperature.AirTemperature;
import org.example.sensor.Sensor;
import org.example.sensor.TemperatureSensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SmartHomeApplication {
    public static void main(String[] args) {
        TemperatureSensor tempSensor = new TemperatureSensor();

        Environment environment = new Environment();
        environment.setAirTemperature(new AirTemperature(13));
        environment.setAirQuality(new AirQuality(50));

        environment.addSubscriber(tempSensor);

        Timer time = new Timer();
        time.schedule(new EnvironmentTask(environment), 0, 1000);
    }
}

class EnvironmentTask extends TimerTask { // move to Environment

    Environment environment;
    public EnvironmentTask(Environment environment) { this.environment = environment; }

    @Override
    public void run() {
        environment.update();
    }
}