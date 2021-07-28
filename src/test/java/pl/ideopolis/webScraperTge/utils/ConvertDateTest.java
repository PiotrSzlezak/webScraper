package pl.ideopolis.webScraperTge.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConvertDateTest {

    @Test
    void convertStringToLocalDateTest() {
        final String pattern1 = "yyyy-MM-dd";
        final String date1 = "Data dostawy: 2021-07-23";
        final String date2 = "1990-01-01";
        final String date3 = "sav/,k,;ijsp;v,fds; 2020-fds a04fvrvr-sdgbrte22dfsv anur  vih";
        final String date4 = "2020-02-31";
        final String date5 = "1895-13-21";

        final Optional<LocalDate> dateOptional1 = ConvertDate.convertStringToLocalDate(date1, pattern1);
        final Optional<LocalDate> dateOptional2 = ConvertDate.convertStringToLocalDate(date2, pattern1);
        final Optional<LocalDate> dateOptional3 = ConvertDate.convertStringToLocalDate(date3, pattern1);

        assertEquals(LocalDate.of(2021,7,23), dateOptional1.get());
        assertEquals("2021-07-23", dateOptional1.get().toString());
        assertEquals(LocalDate.of(1990,1,1), dateOptional2.get());
        assertEquals("1990-01-01", dateOptional2.get().toString());
        assertEquals(LocalDate.of(2020,4,22), dateOptional3.get());
        assertEquals("2020-04-22", dateOptional3.get().toString());
        assertThrows(DateTimeParseException.class,() -> ConvertDate.convertStringToLocalDate(date4, pattern1));
        assertThrows(DateTimeParseException.class,() -> ConvertDate.convertStringToLocalDate(date5, pattern1));
    }

    @Test
    void convertDateToStringTest() {
    }

    @Test
    void msToDayHourMinSecTest() {
        final int SECOND = 1000;
        final int MINUTE = 60 * SECOND;
        final int HOUR = 60 * MINUTE;
        final int DAY = 24 * HOUR;

        final int ms1 = SECOND / 1000;
        final int ms2 = SECOND / 100;
        final int ms3 = SECOND / 10;
        final int ms4 = 1 * SECOND;
        final int ms5 = 1 * MINUTE;
        final int ms6 = 1 * HOUR;
        final int ms7 = 1 * DAY;
        final int ms8 = 2 * DAY;
        final int ms9 = 21 * DAY + 16 * HOUR + 42 * MINUTE + 2 * SECOND + 45;

        final String s1 = ConvertDate.msToDayHourMinSec(ms1);
        final String s2 = ConvertDate.msToDayHourMinSec(ms2);
        final String s3 = ConvertDate.msToDayHourMinSec(ms3);
        final String s4 = ConvertDate.msToDayHourMinSec(ms4);
        final String s5 = ConvertDate.msToDayHourMinSec(ms5);
        final String s6 = ConvertDate.msToDayHourMinSec(ms6);
        final String s7 = ConvertDate.msToDayHourMinSec(ms7);
        final String s8 = ConvertDate.msToDayHourMinSec(ms8);
        final String s9 = ConvertDate.msToDayHourMinSec(ms9);

        assertEquals("0h 0min 0,001s", s1);
        assertEquals("0h 0min 0,010s", s2);
        assertEquals("0h 0min 0,100s", s3);
        assertEquals("0h 0min 1s", s4);
        assertEquals("0h 1min 0s", s5);
        assertEquals("1h 0min 0s", s6);
        assertEquals("1day 0h 0min 0s", s7);
        assertEquals("2days 0h 0min 0s", s8);
        assertEquals("21days 16h 42min 2,045s", s9);
    }
}