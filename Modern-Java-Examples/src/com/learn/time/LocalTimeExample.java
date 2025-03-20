package com.learn.time;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now(); // gives instance of LocalTime, with current machine time
        System.out.println("LocalTime : " + localTime);

        /**
         * of() method has 3 variations
         * of(hour, minute)
         * of(hour, minute, second)
         * of(hour, minute, second, nanoOfSecond)
         */
        LocalTime localTime1 = LocalTime.of(23 , 33);
        System.out.println("LocalTime.of(hour, minute) : " + localTime1);// it didn't print second & nanosecond precision

        LocalTime localTime2 = LocalTime.of(23, 33, 33);
        System.out.println("LocalTime.of(hour, minute, second) : " + localTime2);

        LocalTime localTime3 = LocalTime.of(23, 33, 33, 980980980);
        System.out.println("LocalTime.of(hour, minute, second, nanoOfSecond) : " + localTime3);

        /**
         * getting the values from localTime instance.
         */
        int hour = localTime.getHour();
        System.out.println("getHour() of localTime : " + hour);
        System.out.println("getMinute() of localTime : " + localTime.getMinute());

        System.out.println("get(TemporalField) : " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));

        System.out.println("toSecondOfDay() : " + localTime.toSecondOfDay()); // to represent the localTime in seconds


        /**
         * Modify values of LocalTime
         */
        System.out.println("minusHours() : " + localTime.minusHours(2l));  // subtract hours by 2 and return new instance of LocalTime

        System.out.println("minus(amountToSubtract, TemporalUnit) : " +
                localTime.minus(5, ChronoUnit.HOURS));

        System.out.println("with(TemporalAdjuster) : " + localTime.with(LocalTime.MIDNIGHT)); // it return the time mid night time.


        System.out.println("with(TemporalField, newValue) : " + localTime.with(ChronoField.HOUR_OF_DAY, 22)); // make hour to 22
        System.out.println("with(TemporalField, newValue) : " + localTime.with(ChronoField.MINUTE_OF_DAY, 30)); // make minute to 30

        System.out.println("plusMinutes() : " + localTime.plusMinutes(30));

        System.out.println("withHour() : " + localTime.withHour(5));// to change hour of time and return new instance


    }
}
