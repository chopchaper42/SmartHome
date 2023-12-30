package org.example.environment.airQuality;

import lombok.Getter;
import org.example.environment.EnvironmentParameter;

@Getter
public class AirQuality extends EnvironmentParameter {
    double quality;

    public AirQuality(double quality) {
        if (quality < 0 || quality > 300)
            throw new IllegalArgumentException("Air quality can't be less than 0 or more than 300. Was " + quality);

        this.quality = quality;
    }

    @Override
    public void update() {
        if (tickCounter > 100) {
            quality = Math.random() * 100;
            tickCounter = (int) (Math.random() * 100);
        }
        tickCounter++;
    }
}
