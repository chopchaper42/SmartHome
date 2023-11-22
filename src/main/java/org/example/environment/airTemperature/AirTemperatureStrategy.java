package org.example.environment.airTemperature;

public interface AirTemperatureStrategy {
    double getChange();

    /**
     * Randomly generates temperature decrease from -5 up to 0 degrees Celsius.
     * @return temperature decrease
     */
    default double decreaseTemp() {
        return -1 * Math.random() * 5;
    }

    /**
     * Randomly generates temperature increase from 0 up to 5 degrees Celsius.
     * @return temperature increase
     */
    default double increaseTemp() {
        return Math.random() * 5;
    }
}
