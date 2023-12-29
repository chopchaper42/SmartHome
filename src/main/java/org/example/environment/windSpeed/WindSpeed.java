package org.example.environment.windSpeed;

public class WindSpeed {
    /**
     * Wind speed in meters per second.
     */
    double speed;

    public WindSpeed(double speed) {
        if (speed < 0 || speed > 30)
            throw new IllegalArgumentException("Wind speed can't be less than 0 or more than 30 meters per second. Was " + speed);

        this.speed = speed;
    }
}
