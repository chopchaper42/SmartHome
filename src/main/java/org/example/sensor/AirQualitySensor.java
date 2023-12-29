package org.example.sensor;

public class AirQualitySensor extends Sensor {
    private double previousQuality;
    private static final double LIMIT = 60;

    @Override
    public void reactOnChange(double v) {
        System.out.println("AQ: " + v);
    }

    protected boolean roseAboveLimit(double v) {
        return previousQuality <= LIMIT && v > LIMIT;
    }

    protected boolean droppedBelowLimit(double v) {
        return previousQuality > LIMIT && v <= LIMIT;
    }
}
