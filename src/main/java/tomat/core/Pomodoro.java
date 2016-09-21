package tomat.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.StringJoiner;

public class Pomodoro {
    private State state;
    private String title;
    private String comment;
    private LocalDateTime creationDate;
    private LocalDateTime startTime;
    private LocalDateTime expectedFinishTime;
    private LocalDateTime realFinishTime;

    public Pomodoro(LocalDateTime creationDate,
                    String title,
                    String comment) {

        this.state = State.to_do;
        this.creationDate = creationDate;
        this.title = title;
        this.comment = comment;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getExpectedFinishTime() {
        return expectedFinishTime;
    }

    public void setExpectedFinishTime(LocalDateTime expectedFinishTime) {
        this.expectedFinishTime = expectedFinishTime;
    }

    public LocalDateTime getRealFinishTime() {
        return realFinishTime;
    }

    public void setRealFinishTime(LocalDateTime realFinishTime) {
        this.realFinishTime = realFinishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void start() {
        this.state = State.in_progress;
        this.startTime = LocalDateTime.now();
        this.expectedFinishTime = this.startTime.plusMinutes(Settings.pomodoro_time);
    }

    public String printState() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Title: " + title + "\n")
                     .append("Comment: " + comment + "\n")
                     .append("Start time: " + startTime.toString() + "\n")
                     .append("End time: " + expectedFinishTime.toString() + "\n")
                     .append("Remaining time: " + ChronoUnit.MINUTES.between(startTime, expectedFinishTime) + "\n");
        return stringBuilder.toString();
    }
}
