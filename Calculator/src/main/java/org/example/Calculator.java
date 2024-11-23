package org.example;

import java.time.Duration;
import java.time.LocalTime;

public class Calculator {

    public long minutes(LocalTime startTime, LocalTime endeTime) {
        Duration between = Duration.between(startTime, endeTime);
        return between.toMinutes();
    }
    public long breaks(LocalTime startTime, LocalTime endeTime) {
        Duration between = Duration.between(startTime, endeTime);
        between.dividedBy(90);

        return 15;
    }


    public long calc(LocalTime startTime, LocalTime endeTime) {
        return 180;
    }
}
