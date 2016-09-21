package tomat.main;

import tomat.core.Pomodoro;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Pomodoro pomodoro = new Pomodoro(LocalDateTime.now(), "first task", "first comment");
        System.out.println("Hello, tomat!");
        pomodoro.start();
        String state = pomodoro.printState();
        System.out.println(state);
    }
}
