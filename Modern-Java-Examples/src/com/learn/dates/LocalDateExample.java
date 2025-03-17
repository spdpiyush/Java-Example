package com.learn.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateExample {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate : " + localDate);

        /**
         * of(year, month, dayOfMonth): returns an instance of LocalDate.
         */
        LocalDate localDate1 = LocalDate.of(2025, 3, 16);
        System.out.println("LocalDate1 : " + localDate1);

        /**
         * ofYearDay(year, dayOfYear) : This returns a {@code LocalDate} with the specified year and day-of-year.
         */
        LocalDate localDate2 = LocalDate.ofYearDay(2025, 365);
        System.out.println("LocalDate2 : " + localDate2);


        /**
         * Getting values from LocalDate.
         */
        System.out.println("localDate Month : " + localDate.getMonth());
        System.out.println("localDate Month Value : " + localDate.getMonthValue());

        System.out.println("localDate Day of Week : " + localDate.getDayOfWeek());

        System.out.println("localDate Day of Year : " + localDate.getDayOfYear());

        /**
         * different ways of getting the value
         * get(TemporalField) - it accepts a field called TemporalField
         * ChronoField is an enum which implements TemporalField
         */
        System.out.println("localDate Day Of Month : " + localDate.get(ChronoField.DAY_OF_MONTH));
    }
}
