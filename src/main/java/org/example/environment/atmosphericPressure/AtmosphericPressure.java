package org.example.environment.atmosphericPressure;

public class AtmosphericPressure {
    private double pressure;

    public AtmosphericPressure(double pressure) {
        if (pressure < 700 || pressure > 800)
            throw new IllegalArgumentException("Pressure can't be less than 700 and more than 800 mm Hg. Was " + pressure);

        this.pressure = pressure;
    }
}
