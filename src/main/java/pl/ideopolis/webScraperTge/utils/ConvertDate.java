package pl.ideopolis.webScraperTge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ConvertDate {

    private final static Logger log = LoggerFactory.getLogger(ConvertDate.class);

    public static Optional<LocalDate> convertStringToLocalDate(String stringWithDate, String pattern) {
        log.trace("convertStringToLocalDate method. stringWithDate = {}, pattern = {}", stringWithDate, pattern);
        System.out.println("stringWithDate = "+stringWithDate+"; pattern = "+pattern);
        final String cleanDateString = stringWithDate.replaceAll("[^-0-9]", "");
        System.out.println("cleanDateString = "+cleanDateString);
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(cleanDateString);
        dateTimeFormatter.format(date);
        return Optional.of(date);
    }

    public static String convertDateToString(LocalDate date, String format) {
        log.trace("convertDateToString method. date = {}, format = {}", date, format);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String dateAsString = formatter.format(date);
        return dateAsString;
    }

    public static String msToDayHourMinSec(int ms) {
        int msRest = 0, sec = 0, min = 0, h = 0, day = 0;
        int wholeSec, wholeMin, wholeHours;

        msRest = ms % 1000;
        wholeSec = (ms - msRest)/1000;
        sec = wholeSec % 60;
        wholeMin = (wholeSec - sec)/60;
        min = wholeMin % 60;
        wholeHours = (wholeMin - min)/60;
        h = wholeHours % 24;
        day = (wholeHours - h) / 24;

        String time = "";
        if (day > 0) {
            if (day > 1) {
                time = "" + day + "days ";
            } else {
                time = "" + day + "day ";
            }
        }
        time = time
                + h + "h "
                + min + "min "
                + sec;
        if (msRest > 0) {
            time = time + "," + String.format("%03d", msRest) + "s";
        } else {
            time = time + "s";
        }
        return time;
    }

}
