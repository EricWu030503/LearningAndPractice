public class TimeMeasurement {

    public static void main(String[] args) {
        // Get the start time
        long startTime = System.nanoTime();

        // Sample code whose runtime you want to measure
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }

        // Get the end time
        long endTime = System.nanoTime();

        // Calculate the duration in nanoseconds
        long durationNano = endTime - startTime;

        // Convert the duration to seconds
        double durationSeconds = (double) durationNano / 1_000_000_000.0;

        System.out.println("Runtime of the sample code: " + durationSeconds + " seconds");
    }
}

