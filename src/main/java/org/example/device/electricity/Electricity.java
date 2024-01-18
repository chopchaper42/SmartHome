package org.example.device.electricity;

import lombok.Getter;
import lombok.Setter;

/**
 * Class representing electricity for device
 */
@Getter
@Setter
public class Electricity {
    private final int electricity;

    public Electricity(int electricity) {
        this.electricity = electricity;
    }
}
