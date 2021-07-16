package pl.ideopolis.webScraperTge.tge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrepareURL {

    private final static Logger log = LoggerFactory.getLogger(PrepareURL.class);

    final static private String BASE_URL = "https://tge.pl/energia-elektryczna-rdb";
    final static private String DATE_PARAM = "dateShow";
    final static private String ACTION_PARAM = "dateAction";
    final static private String ACTION_PARAM_VALUE = "prev";
    private String specificDateUrl;
    private String date;

    public PrepareURL() {
        log.trace("No parameter constructor.");
    }

    public String getUrlForToday() {
        log.trace("getUrlForToday method. Retrived URL = {}", BASE_URL);
        return BASE_URL;
    }

    public String geUrlForAnyDate() {
        log.trace("geUrlForAnyDate method. Retrived URL = {}", specificDateUrl);
        return specificDateUrl;
    }

    public void setDate(String date) {
        log.trace("setDate method. date = {}",date);
        this.date = date;
        assembleUrl();
    }

    private void assembleUrl() {
        log.trace("assembleUrl method.");
        StringBuilder sb = new StringBuilder();
        sb
                .append(BASE_URL)
                .append("?")
                .append(DATE_PARAM)
                .append("=")
                .append(date)
                .append("&")
                .append(ACTION_PARAM)
                .append("=")
                .append(ACTION_PARAM_VALUE);
        specificDateUrl = sb.toString();
        log.trace("Assembled url = {}", specificDateUrl);
    }

}
