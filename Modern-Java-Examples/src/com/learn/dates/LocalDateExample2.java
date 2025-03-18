package com.learn.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample2 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        /**
         * Modifying LocalDate
         */

        /**
         * Increment the localDate by 2 days
         * it doesn't change the actual instance.
         * B.coz LocalDate instances that we create are immutable.
         */
        System.out.println("Increment by 2 Days : " + localDate.plusDays(2l));
        System.out.println("Decrease by 2 Days : " + localDate.minusDays(2l));
        System.out.println("Increment by 2 months : " + localDate.plusMonths(2l));

        System.out.println("withYear : " + localDate.withYear(2026)); // it changes year to 2026

        /**
         * with(TemporalAdjuster) :
         * with(TemporalField, long) : Returns a copy of this date with the specified field set to a new value.
         *
         */
        System.out.println("with ChronoField : " + localDate.with(ChronoField.YEAR, 2028));

        // it returns first day of next month from current local date
        System.out.println("with TemporalAdjuster : " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));

        /**
         * minus(long amountToSubtract, TemporalUnit unit)
         * TemporalUnit is an interface and ChronoUnit is an enum which implements TemporalUnit
         */
        System.out.println("Chrono Unit minus year : " + localDate.minus(1, ChronoUnit.YEARS)); // minus year by 1

    }
}
