package com.telran;


import java.time.*;
import java.time.format.DateTimeFormatter;


public class  TimePeriodForWorkers {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTimeNY= LocalDateTime.parse("2020-09-16 08:00:00", formatter);
        LocalDateTime endTimeNY= LocalDateTime.parse("2020-09-16 17:00:00", formatter);

        LocalDateTime startTimeBerlin= LocalDateTime.parse("2020-09-16 09:00:00", formatter);
        LocalDateTime endTimeBerlin= LocalDateTime.parse("2020-09-16 18:00:00", formatter);

      ZonedDateTime zonedDateTimeBerlinStart =ZonedDateTime.
              of(startTimeBerlin,ZoneId.of("Europe/Berlin"));
        ZonedDateTime zonedDateTimeBerlinEnd =ZonedDateTime.
                of(endTimeBerlin,ZoneId.of("Europe/Berlin"));
        ZonedDateTime zonedDateTimeNyStart =ZonedDateTime.
                of(startTimeNY,ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTimeNyEnd =ZonedDateTime.
                of(endTimeNY,ZoneId.of("America/New_York"));

        ZoneId currentZone = ZoneId.of("Europe/Berlin");
        //наиболее поздняя дата в качестве начала общего промежутка
        ZonedDateTime start = zonedDateTimeBerlinStart.isAfter(zonedDateTimeNyStart)
                ? zonedDateTimeBerlinStart : zonedDateTimeNyStart;
        //наиболее ранняя дата в качестве конечной даты
        ZonedDateTime end = zonedDateTimeBerlinEnd.isBefore(zonedDateTimeNyEnd)
                ? zonedDateTimeBerlinEnd : zonedDateTimeNyEnd;
        //ситуация когда пересечения у двух промежутков нет
        if ((start == zonedDateTimeBerlinStart && end == zonedDateTimeBerlinEnd)
                || (start == zonedDateTimeNyStart && end == zonedDateTimeNyEnd))
            System.out.println("No crossing");
        else
            System.out.format("%s, %s ",start.withZoneSameInstant(currentZone),
                    end.withZoneSameInstant(currentZone));
//        System.out.println("Berlin start " + zonedDateTimeBerlinStart);
//        System.out.println("Berlin end" + zonedDateTimeBerlinEnd);
//        System.out.println("NY start " + zonedDateTimeNyStart);
//        System.out.println("NY end " + zonedDateTimeNyEnd);

    }
}


