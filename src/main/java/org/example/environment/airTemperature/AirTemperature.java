package org.example.environment.airTemperature;

public class AirTemperature {

    /**
     * Temperature in Celsius.
     */
    private double temperature;
    private AirTemperatureStrategy strategy;
    public AirTemperature(double temperature, AirTemperatureStrategy strategy) {
        if (temperature < -90 || temperature > 60)
            throw new IllegalArgumentException("Air temperature can't be less than -90 or more than 60 degrees Celsius. Was " + temperature);

        if (strategy == null)
            throw new IllegalArgumentException("AirTemperatureStrategy cannot be null.");

        this.strategy = strategy;
    }

    public void update() {
        double prevTemp = temperature;
        temperature += strategy.getChange();
        changeStrategy(prevTemp);
    }

    private void changeStrategy(double previousTemperature) {
        if (temperature < 0 && previousTemperature >= 0)
            strategy = new LowTemperatureStrategy();
        else if (temperature > 25 && previousTemperature <= 25)
            strategy = new HighTemperatureStrategy();
        else
            strategy = new NormalTemperatureStrategy();
    }
}
