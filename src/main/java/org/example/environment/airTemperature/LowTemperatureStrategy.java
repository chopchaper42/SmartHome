package org.example.environment.airTemperature;

public class LowTemperatureStrategy implements AirTemperatureStrategy{
    @Override
    public double getChange() {
        double changeDirection = Math.random();
        if (changeDirection < 0.2)
            return decreaseTemp();
        else
            return increaseTemp();
    }
}
