package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


public class RechnerTest {

    @Test
    void exakteVerlesungsstundenohnePausen() {
        String start = "09:00";
        String ende = "10:30";

        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endeTime = LocalTime.parse(ende, DateTimeFormatter.ofPattern("HH:mm"));

        Calculator calc = new Calculator();
        long hour = calc.calc(startTime, endeTime);

        assertThat(hour).isEqualTo(90);


    }

    @Test
    void mehrals2Vorlesungsstunden_ergibteinePause() {
        String start = "09:00";
        String ende = "12:00";

        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endeTime = LocalTime.parse(ende, DateTimeFormatter.ofPattern("HH:mm"));

        Calculator calc = new Calculator();
        long hour = calc.calc(startTime, endeTime);

        assertThat(hour).isEqualTo(180);


    }


}
