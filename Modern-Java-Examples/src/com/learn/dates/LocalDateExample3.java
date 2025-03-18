package com.learn.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateExample3 {

    public static void main(String[] args) {

        // Additional Methods on LocalDate

        LocalDate localDate = LocalDate.now();

        // To Check whether Year is Leap Year or not
        System.out.println("Is Leap Year : " + localDate.isLeapYear());

        LocalDate nextDay = LocalDate.now().plusDays(1l);

        //compare 2 dates are equal or not
        System.out.println("is LocalDates are Equal : " + localDate.isEqual(nextDay));

        System.out.println("isBefore : " + localDate.isBefore(nextDay));
        System.out.println("isAfter : " + nextDay.isAfter(localDate));

        /**
         * Unsupported Scenarios
         */

        // what happen if we try to subtract time from LocalDate

        /**
         * It throws UnsupportedTemporalTypeException
         * we can't perform time functionality on a date object.
         */
        System.out.println("ChronoUnit Minus : " + localDate.minus(2, ChronoUnit.MINUTES));

        /**
         * we can use isSupported to check whether that Operation is supported or not
         */
        System.out.println("isSupported : " + localDate.isSupported(ChronoUnit.MINUTES));
    }
}
