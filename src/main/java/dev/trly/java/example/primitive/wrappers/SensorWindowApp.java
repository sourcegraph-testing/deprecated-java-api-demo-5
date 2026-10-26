package dev.trly.java.example.primitive.wrappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SensorWindowApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(SensorWindowApp.class);

    private SensorWindowApp() {
    }

    public static void main(String[] args) {
        final Byte[] samples = {
            new Byte((byte) 12),
            new Byte((byte) 15),
            new Byte((byte) 9),
            new Byte((byte) 14),
            new Byte((byte) 11)
        };
        final Short[] offsets = {
            new Short((short) 120),
            new Short((short) 116),
            new Short((short) 118),
            new Short((short) 121),
            new Short((short) 119)
        };

        int sampleSum = 0;
        int highestSample = Byte.MIN_VALUE;
        int offsetSum = 0;
        for (int index = 0; index < samples.length; index++) {
            final int sample = samples[index].byteValue();
            final int offset = offsets[index].shortValue();
            sampleSum += sample;
            offsetSum += offset;
            if (sample > highestSample) {
                highestSample = sample;
            }
            LOGGER.info("Window {}: sample={} offset={}", index + 1, sample, offset);
        }

        LOGGER.info("Signal average: {}", String.format("%.1f", sampleSum / (double) samples.length));
        LOGGER.info("Offset average: {}", String.format("%.1f", offsetSum / (double) offsets.length));
        LOGGER.info("Peak sample: {}", highestSample);
    }
}
