import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlarmTest {

    @Test
    public void alarmIsOffByDefault() {
        Alarm alarm = new Alarm(null);
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarmIsOffWhenPressureIsNormal() {
        Sensor sensor = new FakeSensor(Alarm.HIGH_PRESSURE_THRESHOLD - 1);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarmIsOnWhenPressureIsUnderThreshold() {
        Sensor sensor = new FakeSensor(Alarm.LOW_PRESSURE_THRESHOLD - 1);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void alarmIsOnWhenPressureIsAboveThreshold() {
        Sensor sensor = new FakeSensor(Alarm.HIGH_PRESSURE_THRESHOLD + 1);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void alarmIsOffWhenReturnFromAbove() {
        FakeSensor sensor = new FakeSensor(Alarm.HIGH_PRESSURE_THRESHOLD + 1);
        Alarm alarm = new Alarm(sensor);

        alarm.check();
        sensor.setPressure(Alarm.HIGH_PRESSURE_THRESHOLD - 1);
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarmIsOffWhenReturnFromBelow() {
        FakeSensor sensor = new FakeSensor(Alarm.LOW_PRESSURE_THRESHOLD - 1);
        Alarm alarm = new Alarm(sensor);

        alarm.check();
        sensor.setPressure(Alarm.LOW_PRESSURE_THRESHOLD + 1);
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }



    // should be off when the pressure is normal +
    // should be on when the pressure is under the threshold +
    // should be on when the pressure is above the threshold +
    // should be off when returns to normal from above +
    // should be off when returns to normal from below +

}
