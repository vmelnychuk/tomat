package tomat.core;

import tomat.util.TimeUtil;

import java.time.LocalDateTime;
import java.util.Optional;

public final class Pomodoro {
    private final String title;
    private final String comment;
    private State state;
    private final LocalDateTime creationDate;
    private Optional<LocalDateTime> startTime = Optional.empty();
    private Optional<LocalDateTime> expectedFinishTime = Optional.empty();
    private Optional<LocalDateTime> finishTime = Optional.empty();
    private long minutesWorked = 0;

    public Pomodoro(String title,
                    String comment) {
        this.creationDate = LocalDateTime.now();
        this.title = title;
        this.comment = comment;
        this.state = State.to_do;
    }

    public Pomodoro(LocalDateTime creationDate,
                    String title,
                    String comment) {
        this.creationDate = creationDate;
        this.title = title;
        this.comment = comment;
        this.state = State.to_do;
    }

    public void start() {
        this.state = State.in_progress;
        this.startTime = Optional.of(LocalDateTime.now());
        this.expectedFinishTime = Optional.of(TimeUtil.getPomodoroEndTime(startTime.get()));
    }

    public void interrupt() {
        this.state = State.interrupted;
        this.finishTime = Optional.of(LocalDateTime.now());
        this.minutesWorked = TimeUtil.minutesBetween(startTime.get(), finishTime.get());
    }

    public void stop() {
        this.state = State.done;
        this.finishTime = Optional.of(LocalDateTime.now());
        this.minutesWorked = TimeUtil.minutesBetween(startTime.get(), finishTime.get());
    }

    private long remainingTime() {
        return TimeUtil.minutesBetween(startTime.get(), expectedFinishTime.get());
    }

    public String printState() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Title: " + title + "\n")
                     .append("Comment: " + comment + "\n");
        if (startTime.isPresent()) {
            stringBuilder = stringBuilder.append("Start time: " + startTime.map(LocalDateTime::toString).orElse("") + "\n");
        }
        if (finishTime.isPresent()) {
             stringBuilder = stringBuilder.append("End time: " + finishTime.map(LocalDateTime::toString).orElse("") + "\n");
        }
        return stringBuilder.toString();
    }
}
