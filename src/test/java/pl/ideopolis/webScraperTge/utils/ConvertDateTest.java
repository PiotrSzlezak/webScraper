package pl.ideopolis.webScraperTge.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertDateTest {

    private static final int SECOND = 1000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    @Test
    void testMsToDayHourMinSec() {
        int ms1 = 1;
        int ms2 = 10;
        int ms3 = 100;
        int ms4 = 1 * SECOND;
        int ms5 = 1 * MINUTE;
        int ms6 = 1 * HOUR;
        int ms7 = 1 * DAY;
        int ms8 = 2 * DAY;
        int ms9 = 21 * DAY + 16 * HOUR + 42 * MINUTE + 2 * SECOND + 45;

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