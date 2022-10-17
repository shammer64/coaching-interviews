public class Alarm {

    public static final double LOW_PRESSURE_THRESHOLD = 17;
    public static final double HIGH_PRESSURE_THRESHOLD = 21;

    Sensor sensor;

    boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        double pressure = sensor.getPressure();
        boolean isBelow = pressure < LOW_PRESSURE_THRESHOLD;
        boolean isAbove = pressure > HIGH_PRESSURE_THRESHOLD;

        alarmOn = isBelow || isAbove;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
