package org.example.environment.airTemperature;

import lombok.Getter;
import org.example.environment.EnvironmentParameter;


public class AirTemperature extends EnvironmentParameter {

    @Getter
    private final double HIGH_TEMP_LIMIT;
    @Getter
    private final double LOW_TEMP_LIMIT;

    /**
     * Temperature in Celsius.
     */
    @Getter
    private double temperature;
    private static int tickCounter = 0;
    private AirTemperatureStrategy strategy;
    public AirTemperature(double temperature, AirTemperatureStrategy strategy, double highTempLimit, double lowTempLimit) {
        if (temperature < -90 || temperature > 60)
            throw new IllegalArgumentException("Air temperature can't be less than -90 or more than 60 degrees Celsius. Was " + temperature);

        this.temperature = temperature;

        if (strategy == null)
            throw new IllegalArgumentException("AirTemperatureStrategy cannot be null.");

        this.strategy = strategy;
        HIGH_TEMP_LIMIT = highTempLimit;
        LOW_TEMP_LIMIT = lowTempLimit;
    }

    public AirTemperature(double temperature, AirTemperatureStrategy strategy) {
        this(temperature, strategy, 25, 8);
    }

    public AirTemperature(double temperature, double highTempLimit, double lowTempLimit) {
        if (temperature < -90 || temperature > 60)
            throw new IllegalArgumentException("Air temperature can't be less than -90 or more than 60 degrees Celsius. Was " + temperature);

        this.temperature = temperature;
        this.strategy = new NormalTemperatureStrategy();
        HIGH_TEMP_LIMIT = highTempLimit;
        LOW_TEMP_LIMIT = lowTempLimit;
    }

    public AirTemperature(double temperature) {
        this(temperature, 25, 8);
    }

    public void update() {
        if (tickCounter > 15) {
            double prevTemp = temperature;
            temperature += strategy.getChange();
            changeStrategy(prevTemp);
            tickCounter = 0;
        }
        tickCounter++;
    }

    private void changeStrategy(double previousTemperature) {
        if (temperature < LOW_TEMP_LIMIT && previousTemperature >= LOW_TEMP_LIMIT) {
            strategy = new LowTemperatureStrategy();
        }
        else if (temperature > HIGH_TEMP_LIMIT && previousTemperature <= HIGH_TEMP_LIMIT) {
            strategy = new HighTemperatureStrategy();
        }
        else if (temperature > LOW_TEMP_LIMIT && previousTemperature <= LOW_TEMP_LIMIT ||
                temperature < HIGH_TEMP_LIMIT && previousTemperature >= HIGH_TEMP_LIMIT) {
            strategy = new NormalTemperatureStrategy();
        }
    }
}
