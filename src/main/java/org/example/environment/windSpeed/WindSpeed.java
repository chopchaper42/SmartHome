package org.example.environment.windSpeed;

import lombok.Getter;
import org.example.environment.EnvironmentParameter;

@Getter
public class WindSpeed extends EnvironmentParameter {
    /**
     * Wind speed in meters per second.
     */
    double speed;

    public WindSpeed(double speed) {
        if (speed < 0 || speed > 30)
            throw new IllegalArgumentException("Wind speed can't be less than 0 or more than 30 meters per second. Was " + speed);

        this.speed = speed;
    }

    @Override
    public void update() {
        if (tickCounter > 50) {
            speed = Math.random() * 20;
            tickCounter = (int) (Math.random() * 50);
        }
        tickCounter++;
    }
}