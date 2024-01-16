package org.example.sensor;

public abstract class Sensor {
    public abstract void reactOnChange(double v);
    /*protected abstract boolean roseAboveHigherLimit(double v);
    protected abstract boolean droppedBelowLowerLimit(double v);
    protected abstract boolean roseAboveLowerLimit(double v);
    protected abstract boolean droppedBelowHigherLimit(double v);*/
}