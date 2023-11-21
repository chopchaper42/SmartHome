package org.example.environment.airTemperature;

public class HighTemperatureStrategy implements AirTemperatureStrategy{
    @Override
    public double getChange() {
        double changeDirection = Math.random();
        if (changeDirection < 0.8)
            return increaseTemp();
        else
            return decreaseTemp();
    }
}
