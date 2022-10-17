import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AlarmTest {

    @Test
    public void alarmIsOffByDefault()
    {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }

}
