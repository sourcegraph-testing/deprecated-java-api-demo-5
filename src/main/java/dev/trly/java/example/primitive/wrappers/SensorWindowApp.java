package dev.trly.java.example.primitive.wrappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SensorWindowApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(SensorWindowApp.class);

    private SensorWindowApp() {
    }

    public static void main(String[] args) {
        final Byte[] samples = {
            Byte.valueOf((byte) 12),
            Byte.valueOf((byte) 15),
            Byte.valueOf((byte) 9),
            Byte.valueOf((byte) 14),
            Byte.valueOf((byte) 11)
        };
        final Short[] offsets = {
            Short.valueOf((short) 120),
            Short.valueOf((short) 116),
            Short.valueOf((short) 118),
            Short.valueOf((short) 121),
            Short.valueOf((short) 119)
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
