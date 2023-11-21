package org.example.environment.airTemperature;

public class NormalTemperatureStrategy implements AirTemperatureStrategy{
    @Override
    public double getChange() {
        double changeDirection = Math.random();
        if (changeDirection < 0.5)
            return decreaseTemp();
        else
            return increaseTemp();
    }
}
