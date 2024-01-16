package org.example.environment.atmosphericPressure;

import lombok.Getter;
import org.example.environment.EnvironmentParameter;

@Getter
public class AtmosphericPressure extends EnvironmentParameter {
    private double pressure;

    public AtmosphericPressure(double pressure) {
        if (pressure < 700 || pressure > 800)
            throw new IllegalArgumentException("Pressure can't be less than 700 and more than 800 mm Hg. Was " + pressure);

        this.pressure = pressure;
    }

    @Override
    public void update() {
        int[] range = { 700, 720, 740, 760, 780, 800 };

        if (tickCounter > 50) {
            int index = (int) (Math.floor(Math.random()));
            pressure = range[index];
            tickCounter = (int) (Math.random() * 50);
        }

        tickCounter++;
    }
}
