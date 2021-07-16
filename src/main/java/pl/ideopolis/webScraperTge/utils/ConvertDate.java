package pl.ideopolis.webScraperTge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ConvertDate {

    private final static Logger log = LoggerFactory.getLogger(ConvertDate.class);

    public static Optional<LocalDate> convertStringToLocalDate(String dateAsString, String pattern) {
        log.trace("convertStringToLocalDate method. dateAsString = {}, pattern = {}", dateAsString, pattern);
        final String[] strings = dateAsString.split(" ");
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(strings[2]);
        dateTimeFormatter.format(date);
        return Optional.of(date);
    }

    public static String convertDateToString(LocalDate date, String format) {
        log.trace("convertDateToString method. date = {}, format = {}", date, format);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String dateAsString = formatter.format(date);
        return dateAsString;
    }

}
