package com.adameric.testejava.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataUtil {

    public static long obterDiferencaDias(String checkIn, String checkOut) {

        LocalDate checkinDate = LocalDate.parse(checkIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate checkOutDate = LocalDate.parse(checkOut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return ChronoUnit.DAYS.between(checkinDate, checkOutDate) + 1;
    }
}
