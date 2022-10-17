import java.util.Random;

public class VirtualSensor implements Sensor {

    private static double OFFSET = 16;

    @Override
    public double getPressure() {
        double pressureTelemetryValue = samplePressure();
        return OFFSET + pressureTelemetryValue;
    }

    private static double samplePressure() {
        // placeholder implementation that simulates a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        return 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
    }
}
