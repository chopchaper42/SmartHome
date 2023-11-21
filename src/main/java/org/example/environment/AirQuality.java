package org.example.environment;

public class AirQuality {
    int quality;

    public AirQuality(int quality) {
        if (quality < 0 || quality > 300)
            throw new IllegalArgumentException("Air quality can't be less than 0 or more than 300. Was " + quality);

        this.quality = quality;
    }
}
