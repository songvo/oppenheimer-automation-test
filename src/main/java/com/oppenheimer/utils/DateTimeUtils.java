package com.oppenheimer.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static int calculateAgeWithFormat(String birthday, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate birthdayLocal = LocalDate.parse(birthday, formatter);
        LocalDate now = LocalDate.now();
        return calculateAge(birthdayLocal, now);
    }
}
