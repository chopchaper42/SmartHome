package org.example.sensor;

public class TemperatureSensor {
    private final double LOWER_LIMIT = 10;
    private final double HIGHER_LIMIT = 25;
    private double previousTemperature;
    public void reactOnChange(double temperature) {
        if (roseAboveHigherLimit(temperature))
            System.out.println("Enabling cooling on the thermostat");
        else if (droppedBelowHigherLimit(temperature))
            System.out.println("Disabling cooling on the thermostat");
        else if (droppedBelowLowerLimit(temperature))
            System.out.println("Enabling heating on the thermostat");
        else if (roseAboveLowerLimit(temperature))
            System.out.println("Disabling heating on the thermostat");
    }

    private boolean roseAboveHigherLimit(double temperature) {
        return temperature > HIGHER_LIMIT && previousTemperature <= HIGHER_LIMIT;
    }
    private boolean droppedBelowLowerLimit(double temperature) {
        return temperature < LOWER_LIMIT && previousTemperature >= LOWER_LIMIT;
    }
    private boolean roseAboveLowerLimit(double temperature) {
        return temperature >= LOWER_LIMIT && previousTemperature < LOWER_LIMIT;
    }
    private boolean droppedBelowHigherLimit(double temperature) {
        return temperature <= HIGHER_LIMIT && previousTemperature < HIGHER_LIMIT;
    }
}
