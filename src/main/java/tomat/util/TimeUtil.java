package tomat.util;

import tomat.enviroment.Settings;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class TimeUtil {
    public static LocalDateTime getPomodoroEndTime(LocalDateTime startTime) {
        return startTime.plusMinutes(Settings.pomodoro_time);
    }

    public static long minutesBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return ChronoUnit.MINUTES.between(startTime, endTime);
    }
}
