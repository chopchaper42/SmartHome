package org.example.device.electricity;

/**
 * Represents a record of electricity consumption.
 */
public class ElectricityRecord {

    private int electricity;

    public ElectricityRecord() {
        electricity = 0;
    }

    /**
     * Increases the recorded electricity value by the amount obtained from the provided Electricity object.
     *
     * @param el the Electricity object representing the amount of electricity to be added to the record
     */
    public void growElectricity(Electricity el){
        electricity += el.getElectricity();
    }
}
