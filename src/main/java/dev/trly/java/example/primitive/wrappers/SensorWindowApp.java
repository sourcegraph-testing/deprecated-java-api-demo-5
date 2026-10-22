package dev.trly.java.example.primitive.wrappers;

public final class SensorWindowApp {
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
            System.out.printf("Window %d: sample=%d offset=%d%n", index + 1, sample, offset);
        }

        System.out.printf("Signal average: %.1f%n", sampleSum / (double) samples.length);
        System.out.printf("Offset average: %.1f%n", offsetSum / (double) offsets.length);
        System.out.printf("Peak sample: %d%n", highestSample);
    }
}
