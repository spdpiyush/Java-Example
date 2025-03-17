package com.learn.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateTimeExample {

    public static void main(String[] args) {

        /**
         * LocalDate is a type Temporal
         */
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate : " + localDate); // gives current machine local date.

        /**
         * LocalTime is also of type Temporal
         * it also implements Comparable<LocalTime>
         */
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime : " + localTime); // gives current time of machine.

        /**
         * LocalDateTime is a combination of both.
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDatTime : " + localDateTime); // gives machine date and time together
    }
}
