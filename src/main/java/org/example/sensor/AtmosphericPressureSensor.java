package org.example.sensor;

public class AtmosphericPressureSensor extends Sensor {
    @Override
    public void reactOnChange(double v) {
        System.out.println("Atm. Pressure: " + v);
    }
}
