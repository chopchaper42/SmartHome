package org.example.sensor;

public class TemperatureSensor extends Sensor {
    private final double LOWER_LIMIT = 10;
    private final double HIGHER_LIMIT = 25;
    private double previousTemperature;
    public void reactOnChange(double temperature) { // modify
        System.out.println("Temperature: " + temperature);
        if (roseAboveHigherLimit(temperature))
            System.out.println("Enabling cooling on the thermostat");
        else if (droppedBelowHigherLimit(temperature))
            System.out.println("Disabling cooling on the thermostat");
        else if (droppedBelowLowerLimit(temperature))
            System.out.println("Enabling heating on the thermostat");
        else if (roseAboveLowerLimit(temperature))
            System.out.println("Disabling heating on the thermostat");

        previousTemperature = temperature;
    }

    protected boolean roseAboveHigherLimit(double temperature) {
        return temperature > HIGHER_LIMIT && previousTemperature <= HIGHER_LIMIT;
    }
    protected boolean droppedBelowLowerLimit(double temperature) {
        return temperature < LOWER_LIMIT && previousTemperature >= LOWER_LIMIT;
    }
    protected boolean roseAboveLowerLimit(double temperature) {
        return temperature >= LOWER_LIMIT && previousTemperature < LOWER_LIMIT;
    }
    protected boolean droppedBelowHigherLimit(double temperature) {
        return temperature <= HIGHER_LIMIT && previousTemperature > HIGHER_LIMIT;
    }
}
