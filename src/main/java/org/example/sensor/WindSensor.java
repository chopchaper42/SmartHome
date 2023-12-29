package org.example.sensor;

public class WindSensor extends Sensor {
    @Override
    public void reactOnChange(double v) {
        System.out.println("Wind speed: " + v);
    }
}
