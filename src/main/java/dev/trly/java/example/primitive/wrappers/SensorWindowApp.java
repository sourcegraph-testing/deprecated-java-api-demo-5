package dev.trly.java.example.primitive.wrappers;

public final class SensorWindowApp {
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
            System.out.printf("Window %d: sample=%d offset=%d%n", index + 1, sample, offset);
        }

        System.out.printf("Signal average: %.1f%n", sampleSum / (double) samples.length);
        System.out.printf("Offset average: %.1f%n", offsetSum / (double) offsets.length);
        System.out.printf("Peak sample: %d%n", highestSample);
    }
}
