package pl.ideopolis.webScraperTge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Optional;

public class BigDecimalConvertion {

    private final static Logger log = LoggerFactory.getLogger(BigDecimalConvertion.class);

    public static Optional<BigDecimal> stringToBigDecimal(String string) {
        log.trace("stringToBigDecimal method. string = " + string);
        if (checkIfStringContainsAtLeastOneDigit(string)) {
        } else {
            return Optional.empty();
        }
        BigDecimal bigDecimal;
        String[] strings = string.split("[0-9]");
        String separator = "";
        int counter = 0;
        for (String s : strings) {
            if (!s.isBlank()) {
                separator = s;
            }
            counter++;
        }
        if (!separator.isBlank()) {
            if (!separator.equals(".")) {
                string = string.replace(separator, ".");
            }
        }
        bigDecimal = new BigDecimal(string);
        return Optional.of(bigDecimal);
    }

    public static boolean checkIfStringContainsAtLeastOneDigit(String numberAsString) {
        log.trace("checkIfStringContainsAtLeastOneDigit method. numberAsString = " + numberAsString);
        Objects.requireNonNull(numberAsString);
        return numberAsString.matches(".*\\d.*");
    }

    public static String bigDecimalToPlainStringIfNotNull(BigDecimal bigDecimal) {
        log.trace("bigDecimalToPlainStringIfNotNull method. bigDecimal = " + bigDecimal);
        if (Objects.isNull(bigDecimal)) {
            log.trace("BigDecimal = null.");
            return null;
        }
        DecimalFormat formatter = new DecimalFormat("#0.00#");
        return formatter.format(bigDecimal).replace(",", ".");
    }

}
